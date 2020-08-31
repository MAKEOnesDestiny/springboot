package com.zhou.springboot.netty;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.PooledByteBufAllocator;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandler;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.util.Date;

public class ChannelReponseHandler extends ChannelInboundHandlerAdapter implements ChannelInboundHandler {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        if (!ctx.channel().config().isAutoRead()) {
            System.out.println("服务端暂停");
            System.out.println(new Date());
            return;
        }
        System.out.println("接收到客户端消息");
        ByteBuf re = new PooledByteBufAllocator().buffer();
        re.writeBytes("我是来自服务端的响应消息".getBytes());
        ctx.pipeline().writeAndFlush(re);
//        ctx.fireChannelActive()
        System.out.println("服务端返回消息给客户端");
//        ctx.fireChannelRead(msg);
    }
}
