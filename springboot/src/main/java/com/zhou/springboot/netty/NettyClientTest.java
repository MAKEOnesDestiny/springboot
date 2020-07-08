package com.zhou.springboot.netty;

import com.zhou.springboot.utils.ExceptionUtil;
import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.PooledByteBufAllocator;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.ByteToMessageCodec;
import io.netty.handler.codec.MessageToByteEncoder;
import io.netty.handler.traffic.GlobalTrafficShapingHandler;

import java.util.List;

public class NettyClientTest {

    public static void main(String[] args) throws InterruptedException {
        EventLoopGroup group = new NioEventLoopGroup();
        Bootstrap bootstrap = new Bootstrap().channel(NioSocketChannel.class)
                .option(ChannelOption.TCP_NODELAY, true).group(group)
                .handler(new ChannelInitializer<NioSocketChannel>() {
                    @Override
                    protected void initChannel(NioSocketChannel ch) throws Exception {
                        ch.pipeline()
                                .addLast(new MessageToByteEncoder<byte[]>() { //outbound
                                    @Override
                                    protected void encode(ChannelHandlerContext ctx, byte[] msg, ByteBuf out) throws Exception {
                                        System.out.println(11);
                                    }
                                })
                                .addLast(new A()) //in out
                                .addLast(new GlobalTrafficShapingHandler(group, 1, 1, 1, 5000)); //in out
//                                .addLast(new LengthFieldBasedFrameDecoder(Integer.MAX_VALUE, 0, 10)); //in
                    }
                });
        ChannelFuture cf = bootstrap.connect("127.0.0.1", 9999).sync();
        String request = "我是客户端请求";
        ByteBuf re = new PooledByteBufAllocator().buffer();
        re.writeBytes(request.getBytes());
        cf.channel().writeAndFlush(re).addListener((f) -> {
            if (f.isSuccess()) {
                System.out.println("发送成功");
            } else {
                System.out.println(ExceptionUtil.getStackTraceString(f.cause()));
            }
        });

    }

    public static class A extends ByteToMessageCodec<ByteBuf> {
        @Override
        protected void encode(ChannelHandlerContext ctx, ByteBuf msg, ByteBuf out) throws Exception { //out
            out.writeBytes(msg);
        }

        @Override
        protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception { //in
            byte[] bytes = new byte[in.readableBytes()];
            in.readBytes(bytes);
            String s = new String(bytes);
            System.out.println("得到消息：" + s);
            out.add(s);
        }

        @Override
        public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
            System.out.println(cause);
        }
    }

}
