package com.road.nio.selector;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

/**
 * @Describe
 * @Author Road
 * @Date 2019/3/4 15:15
 **/
public class SelectorServer {
    private static final int PORT = 1234;
    private static ByteBuffer buffer = ByteBuffer.allocate(1024);

    public static void main(String[] args) {
        try {
            ServerSocketChannel ssc = ServerSocketChannel.open();
            ssc.bind(new InetSocketAddress(PORT));
            ssc.configureBlocking(false);

            // 1.register
            Selector selector = Selector.open();
            ssc.register(selector, SelectionKey.OP_ACCEPT);
            System.out.println("register channel, channel number is :" + selector.keys().size());

            while (true) {
                // 2.select()
                int n = selector.select();
                if (n == 0) {
                    continue;
                }
                // 3.轮询SelectionKey
                Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
                while (iterator.hasNext()) {
                    SelectionKey key = iterator.next();
                    // 如果满足Acceptable条件，则必定是一个ServerSocketChannel
                    if (key.isAcceptable()) {
                        ServerSocketChannel sscTemp = (ServerSocketChannel)key.channel();
                        // 得到一个连接好的SocketChannel，并把它注册到Selector
                        SocketChannel socketChannel = sscTemp.accept();
                        socketChannel.configureBlocking(false);
                        socketChannel.register(selector, SelectionKey.OP_READ);
                        System.out.println("register channel,channel number is :" + selector.keys().size());
                    }
                    // 如果满足Readable条件，则必定是个SocketChannel
                    if (key.isReadable()) {
                        // 读取通道中的数据
                        SocketChannel channel = (SocketChannel)key.channel();
                        readFormChannel(channel);
                    }

                    // 4.remove SelectionKey
                    iterator.remove();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void readFormChannel(SocketChannel channel) {
        try {
            int count;
            buffer.clear();
            while ((count = channel.read(buffer)) > 0) {
                buffer.flip();
                byte[] bytes = new byte[buffer.remaining()];
                buffer.get(bytes);
                System.out.println("read from client: " + new String(bytes));
            }
            if (count < 0) {

                channel.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
