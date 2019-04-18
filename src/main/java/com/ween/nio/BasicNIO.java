package com.ween.nio;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by ween on 2019/3/20
 */
public class BasicFileChannel {

    public static void main(String[] args) throws IOException {
        RandomAccessFile aFile = new RandomAccessFile("E:/data/nio-data.txt", "rw");
        FileChannel inChannel=aFile.getChannel();

        ByteBuffer buf=ByteBuffer.allocate(48);
        int readBytes=inChannel.read(buf);
        while (readBytes!=-1){
            System.out.println("读取来自channel中缓冲区数据:"+readBytes);;
            buf.flip();
            while (buf.hasRemaining()){
                System.out.println((char)buf.get());
            }
            buf.clear();
            readBytes=inChannel.read(buf);
        }
        aFile.close();
    }
}
