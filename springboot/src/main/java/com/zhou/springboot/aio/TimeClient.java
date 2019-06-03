package com.zhou.springboot.aio;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.util.concurrent.CountDownLatch;

public class TimeClient {

    public static class AsyncTimeClientHandler implements CompletionHandler<Void, AsyncTimeClientHandler>, Runnable {

        public String host;

        public int port;

        public AsynchronousSocketChannel client;

        public CountDownLatch latch;

        @Override
        public void run() {
            System.out.println("client is ready to connect to server!");
            client.connect(new InetSocketAddress(host, port), this, this);

            try {
                latch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                client.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public AsyncTimeClientHandler(String host, int port) {
            this.host = host;
            this.port = port;
            this.latch = new CountDownLatch(1);
            try {
                this.client = AsynchronousSocketChannel.open();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void completed(Void result, AsyncTimeClientHandler attachment) {
            byte[] req = null;
            try {
                req = "QUERY".getBytes("UTF-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            ByteBuffer byteBuffer = ByteBuffer.allocate(req.length);
            byteBuffer.put(req);
            byteBuffer.flip();
            attachment.client.write(byteBuffer, byteBuffer, new WriteCompletionHandler());
        }

        @Override
        public void failed(Throwable exc, AsyncTimeClientHandler attachment) {
            try {
                attachment.client.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public class WriteCompletionHandler implements CompletionHandler<Integer, ByteBuffer> {

            @Override
            public void completed(Integer result, ByteBuffer attachment) {
                if (attachment.hasRemaining()) {
                    //写半包
                    client.write(attachment, attachment, this);
                } else {
                    ByteBuffer readBuffer = ByteBuffer.allocate(1024);
                    client.read(readBuffer, readBuffer, new ReadCompletionHandler());
                }

            }

            @Override
            public void failed(Throwable exc, ByteBuffer attachment) {
                try {
                    client.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        public class ReadCompletionHandler implements CompletionHandler<Integer, ByteBuffer> {

            @Override
            public void completed(Integer result, ByteBuffer attachment) {
                attachment.flip();
                byte[] bytes = new byte[attachment.remaining()];
                attachment.get(bytes);
                String body;
                try {
                    body = new String(bytes, "UTF-8");
                    System.out.println("Now is :" + body);
                    latch.countDown();
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void failed(Throwable exc, ByteBuffer attachment) {
                try {
                    client.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }


}
