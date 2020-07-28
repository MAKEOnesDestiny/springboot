package com.zhou.springboot.netty;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundHandler;
import io.netty.channel.ChannelOutboundHandlerAdapter;

import java.util.Date;

public class TestTCCountHandler extends ChannelOutboundHandlerAdapter implements ChannelOutboundHandler {

    @Override
    public void read(ChannelHandlerContext ctx) throws Exception {
        System.out.println("奇奇怪怪");
        System.out.println(new Date());
        ctx.read();
    }
}
