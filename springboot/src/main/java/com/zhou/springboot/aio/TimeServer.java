package com.zhou.springboot.aio;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.util.Date;
import java.util.concurrent.CountDownLatch;

public class TimeServer {

    public static void main(String[] args) {
        new Thread(new AsyncTimeServerHandler(5000),"server-thread").start();
        new Thread(new TimeClient.AsyncTimeClientHandler("127.0.0.1", 5000),"client-thread").start();
    }

    public static class AsyncTimeServerHandler implements Runnable {

        private int port;

        CountDownLatch countDownLatch;

        AsynchronousServerSocketChannel asynchronousServerSocketChannel;

        public AsyncTimeServerHandler(int port) {
            this.port = port;
            try {
                asynchronousServerSocketChannel = AsynchronousServerSocketChannel.open();
                asynchronousServerSocketChannel.bind(new InetSocketAddress(port));
                System.out.println("The time server start...");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void run() {
            countDownLatch = new CountDownLatch(1);
            doAccept();
            try {
                countDownLatch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        public void doAccept() {
            asynchronousServerSocketChannel.accept(this, new AcceptCompletionHandler());
            System.out.println("time server is ready to accept!");
        }


        public class AcceptCompletionHandler implements CompletionHandler<AsynchronousSocketChannel, AsyncTimeServerHandler> {

            @Override
            public void completed(AsynchronousSocketChannel result, AsyncTimeServerHandler attachment) {
                System.out.println("time server has accepted a socket connect!");
                //recursive accept
                attachment.asynchronousServerSocketChannel.accept(attachment, this);

                ByteBuffer buffer = ByteBuffer.allocate(1024);
                result.read(buffer, buffer, new ReadCompletionHandler(result));
            }

            @Override
            public void failed(Throwable exc, AsyncTimeServerHandler attachment) {
                try {
                    attachment.asynchronousServerSocketChannel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


        public class ReadCompletionHandler implements CompletionHandler<Integer, ByteBuffer> {

            private AsynchronousSocketChannel asynchronousSocketChannel;

            public ReadCompletionHandler(AsynchronousSocketChannel channel) {
                this.asynchronousSocketChannel = channel;
            }

            @Override
            public void completed(Integer result, ByteBuffer attachment) {
                attachment.flip();
                byte[] body = new byte[attachment.remaining()];
                attachment.get(body);
                try {
                    String req = new String(body, "UTF-8");
                    System.out.println("The time server receive order:" + req);
                    String current = "QUERY".equalsIgnoreCase(req) ? new Date(System.currentTimeMillis()).toString() : "BAD ORDER";
                    doWrite(current);
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }

            private void doWrite(String currentTime) {
                if (currentTime != null) {
                    byte[] bytes = currentTime.getBytes();
                    ByteBuffer writeBuffer = ByteBuffer.allocate(bytes.length);
                    writeBuffer.put(bytes);
                    writeBuffer.flip();
                    System.out.println("Time server is ready to write message to client!");
                    asynchronousSocketChannel.write(writeBuffer, writeBuffer, new CompletionHandler<Integer, ByteBuffer>() {

                        @Override
                        public void completed(Integer result, ByteBuffer attachment) {
                            System.out.println(this.getClass().getName());
                            if (writeBuffer.hasRemaining()) {
                                //not completed yet
                                asynchronousSocketChannel.write(writeBuffer, writeBuffer, this);
                            }else{
                                System.out.println("server has completed sending message to client");
                                countDownLatch.countDown();
                            }
                        }

                        @Override
                        public void failed(Throwable exc, ByteBuffer attachment) {
                            try {
                                asynchronousSocketChannel.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    });
                }
            }


            @Override
            public void failed(Throwable exc, ByteBuffer attachment) {
                try {
                    asynchronousSocketChannel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }





}
