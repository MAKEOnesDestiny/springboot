package com.zhou.springboot.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.traffic.GlobalTrafficShapingHandler;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class NettyServerTest {

    public static void main(String[] args) throws InterruptedException {
        ThreadLocal<String> threadLocal = new ThreadLocal<String>(){
            @Override
            protected String initialValue() {
                return "1111";
            }
        };

        ScheduledExecutorService es = Executors.newScheduledThreadPool(5);
        ServerBootstrap serverBootstrap = new ServerBootstrap();
        serverBootstrap.group(new NioEventLoopGroup(), new NioEventLoopGroup())
                .channel(NioServerSocketChannel.class)
//                .option(ChannelOption.SO_BACKLOG, 10000)
                .option(ChannelOption.TCP_NODELAY, true)
                .childHandler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel socketChannel) throws Exception {
                        socketChannel.pipeline()

                                .addLast(new ChannelReponseHandler()); //in
//                                .addLast(new TestTCCountHandler()); //out
//                                .addLast(new LengthFieldBasedFrameDecoder(Integer.MAX_VALUE, 0, 10));
                    }
                }).bind("127.0.0.1", 9999).sync();
        System.out.println("server启动成功");
    }

}
