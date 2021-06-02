package net.xuexi.encoder;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

public class CustomEncoder extends MessageToByteEncoder<Integer> {

    protected void encode(ChannelHandlerContext channelHandlerContext, Integer integer, ByteBuf out) throws Exception {
        // 调用write方法，会先判断是否支持，不支持则穿透。
        out.writeInt(integer);



    }
}
