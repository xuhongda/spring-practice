package com.xu.netty.first;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.util.concurrent.Future;

/**
 * @author xuhongda on 2019/3/13
 * com.xu.netty.first
 * java-action
 */
public class ServerTest {

    //建立两个线程组
    //接受请求
    static EventLoopGroup bossGroup = new NioEventLoopGroup();
    //处理请求
   static EventLoopGroup workerGroup = new NioEventLoopGroup();
    static  ServerBootstrap serverBootstrap ;

    public static boolean start() throws InterruptedException {

        try {
            serverBootstrap = new ServerBootstrap();
            serverBootstrap.group(bossGroup,workerGroup).channel(NioServerSocketChannel.class).childHandler(new InitializerTest());
            ChannelFuture future = serverBootstrap.bind(8081).sync();
            future.channel().closeFuture().sync();
            return true;
        }finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }

    }


    public static boolean close() throws InterruptedException {
        Future<?> future = bossGroup.shutdownGracefully();
        workerGroup.shutdownGracefully();

        return true;
    }

}
