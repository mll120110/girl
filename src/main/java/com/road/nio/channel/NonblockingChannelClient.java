package com.road.nio.channel;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.concurrent.TimeUnit;

/**
 * @Describe 非阻塞通道客户端
 * @Author Road
 * @Date 2019/3/4 11:38
 **/
public class NonblockingChannelClient {
    public static void main(String[] args) {
        try {
            SocketChannel sc = SocketChannel.open();
            sc.configureBlocking(false);
            sc.connect(new InetSocketAddress("127.0.0.1", 1234));
            while (!sc.finishConnect()) {
                System.out.println("connect has not finished, wait...");
                TimeUnit.SECONDS.sleep(1);
            }

            ByteBuffer buffer = ByteBuffer.allocate(1024);
            writeString(buffer, sc, "hello");
            writeString(buffer, sc, "world");
            writeString(buffer, sc, "exit");
            sc.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 
     * @param buffer
     * @param sc
     * @param str
     */
    private static void writeString(ByteBuffer buffer, SocketChannel sc, String str) {
        buffer.clear();
        buffer.put(str.getBytes()).flip();
        System.out.println("buffer is output:" + buffer.put(str.getBytes()).flip());
        try {
            sc.write(buffer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
