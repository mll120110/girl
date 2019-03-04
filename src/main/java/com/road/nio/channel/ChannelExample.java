package com.road.nio.channel;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;

/**
 * @Describe
 * @Author Road
 * @Date 2019/3/1 17:04
 **/
public class ChannelExample {
    /**
     * 易读字节通道--buffer缓冲区--写自己通道
     *
     */
    private static void byteChannelCreate() {
        ReadableByteChannel readableByteChannel = Channels.newChannel(System.in);
        WritableByteChannel writableByteChannel = Channels.newChannel(System.out);
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        try {
            while (readableByteChannel.read(buffer) != -1) {
                buffer.flip();
                while (buffer.hasRemaining()) {
                    writableByteChannel.write(buffer);
                }
                buffer.clear();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * @throws IOException
     */
    private static void testFileChannelCreate() throws IOException {
        final String filePath = "E:\\opt\\a.txt";

        // 该类可读也可写入文件
        RandomAccessFile randomAccessFile = new RandomAccessFile(filePath, "rw");
        //
        FileChannel readAndWriteChannel = randomAccessFile.getChannel();
        FileInputStream fileInputStream = new FileInputStream(filePath);
        FileChannel readChannel1 = fileInputStream.getChannel();
        FileOutputStream fileOutputStream = new FileOutputStream(filePath);
        FileChannel writeChannel = fileOutputStream.getChannel();

        readAndWriteChannel.close();
        readChannel1.close();
        writeChannel.close();
    }

    /**
     *
     */
    private static void testFilePosition() {
        final String filePath = "C:\\opt\\a.txt";
        try {
            // create a file with 26 char a-z
            FileOutputStream fileOutputStream = new FileOutputStream(filePath);
            StringBuilder stringBuilder = new StringBuilder();
            for (char c = 'a'; c <= 'z'; c++) {
                stringBuilder.append(c);
            }
            fileOutputStream.write(stringBuilder.toString().getBytes());
            fileOutputStream.flush();
            fileOutputStream.close();

            // create FileChannel
            RandomAccessFile randomAccessFile = new RandomAccessFile(filePath, "rw");
            FileChannel fileChannel = randomAccessFile.getChannel();
            System.out.println("file position in FileChannel is :" + fileChannel.position());
            randomAccessFile.seek(5);
            System.out.println("file position in FileChannel is :" + fileChannel.position());
            fileChannel.position(10);
            System.out.println("file position in RandomAccessFile is :" + randomAccessFile.getFilePointer());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        testFilePosition();
    }
}
