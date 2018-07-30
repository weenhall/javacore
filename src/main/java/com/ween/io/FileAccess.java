package com.ween.io;

import sun.nio.ch.IOUtil;

import java.io.*;
import java.util.Random;

//文件访问
public class FileAccess {
    private static final String IN_FILEPATH = "D://blog/debug.log";
    private static final String OU_FILEPATH = "D://blog/ou.log";

    public static void main(String[] args) throws Exception {
       AccessFileAsRandom();
    }


    //1.单字节读取文件
    public static void readFileAsByte() throws IOException {
        InputStream is = null;
        try {
            is = new FileInputStream(IN_FILEPATH);
            int data = -1;
            while ((data = is.read()) != -1) {//-1表示读取到文件末尾
                System.out.println((byte) data + "  ");
            }
        } finally {
            if (is != null) {
                is.close();
            }
        }
    }

    //2.字节数组读取文件
    public static void readFileAsByteArray() throws IOException {
        InputStream is = null;
        try {
            is = new BufferedInputStream(new FileInputStream(IN_FILEPATH));
            byte data[] = new byte[256];
            int len = -1;
            while ((len = is.read(data)) != -1) {
                for (int i = 0; i < len; i++) {
                    System.out.println(data[i] + " ");
                }
            }
        } finally {
            if (is != null) {
                is.close();
            }
        }
    }

    //3.单字符读取文件
    public static void readFileAsChar() throws IOException {
        Reader reader = null;
        try {
            reader = new FileReader(IN_FILEPATH);
            int data = -1;
            while ((data = reader.read()) != -1) {
                System.out.println((char) data);
            }
        } finally {
            if (reader != null) {
                reader.close();
            }
        }
    }

    //4.字符数组读取文件
    public static void readFileAsCharArray() throws IOException {
        Reader reader = null;
        try {
            reader = new BufferedReader(new FileReader(IN_FILEPATH));
            char[] data = new char[256];
            int len = -1;
            while ((len = reader.read(data)) != -1) {
                for (int i = 0; i < len; i++) {
                    System.out.println(data[i]);
                }
            }
        } finally {
            if (reader != null) {
                reader.close();
            }
        }
    }

    //5.单字节写入文件
    public static void writeFileAsByte() throws IOException {
        OutputStream os = null;
        try {
            os = new FileOutputStream(OU_FILEPATH);
            os.write('1');
            os.write('2');
            os.write('3');
            os.flush();//把缓存区数据刷新到磁盘
        } finally {
            if (os != null) {
                os.close();
            }
        }
    }

    //6.字节数组写入文件
    public static void writeFileAsByteArray() throws IOException {
        OutputStream os = null;
        try {
            os = new BufferedOutputStream(new FileOutputStream(OU_FILEPATH));
            byte[] data = new byte[256];
            new Random().nextBytes(data);

            os.write(data);
            os.flush();
        } finally {
            if (os != null) {
                os.close();
            }
        }

    }

    //7.单字符写入文件
    public static void writeFileAsChar() throws IOException {
        Writer w = null;
        try {
            w = new FileWriter(OU_FILEPATH);
            w.write('1');
            w.write('2');
            w.write('3');
            w.flush();
        } finally {
            if (w != null) {
                w.close();
            }
        }
    }

    //8.字符数组写入文件
    public static void writeFileAsCharArray() throws IOException {
        Writer w = null;
        try {
            w = new BufferedWriter(new FileWriter(OU_FILEPATH));
            char[] data = new char[256];
            String str = "13243klsdkflsk";
            Random rd = new Random();
            for (int i = 0; i < data.length; i++) {
                data[i] = str.charAt(rd.nextInt(str.length()));
            }
            w.write(data);
            w.flush();
        } finally {
            if (w != null) {
                w.close();
            }
        }
    }

    //9.随机访问文件
    public static void AccessFileAsRandom() throws IOException{
        RandomAccessFile file=null;
        try {
            file=new RandomAccessFile(IN_FILEPATH,"rw");

            file.seek(0);
            file.writeChar('1');
            file.seek(0);
            System.out.println(file.readChar());

            int data=-1;
            while ((data=file.read())!=-1){
                System.out.println((byte) data+" ");
            }
        }finally {
            if(file!=null){
                file.close();
            }
        }
    }

}
