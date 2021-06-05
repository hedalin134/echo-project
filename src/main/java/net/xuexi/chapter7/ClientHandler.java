package net.xuexi.chapter7;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class ClientHandler extends ChannelInboundHandlerAdapter {

/*    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        ByteBuf mes = null;
        byte[] req = ("xdclass.net" +System.getProperty("line.separator")).getBytes();
        for (int i = 0; i < 100; i++) {
            mes = Unpooled.buffer(req.length);
            mes.writeBytes(req);
            ctx.writeAndFlush(mes);
        }
    }*/

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        String msg = "Netty is a NIO client server framework which enables quick and easy " +
                "development of network applications such as protocol servers and " +
                "clients. It greatly simplifies and streamlines network programming " +
                "such as TCP and UDP socket server. ";
        ByteBuf out = null;
        out = Unpooled.buffer(msg.getBytes().length);
        out.writeBytes(msg.getBytes());
        ctx.writeAndFlush(out);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
