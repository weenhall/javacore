package com.ween.io;

import java.io.File;
import java.io.IOException;

/**
 * Created by wen on 2018/3/23
 */
public class FileUtil {

    public static String TESTPAHT="D:"+File.separator+"hello.txt";

    public void createFile(String filePath){
        File file=new File(filePath);
        try {
            file.createNewFile();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void removeFile(String filePath){
        File file=new File(filePath);
        if(file.exists()){
            file.delete();
        }
    }

    public void createFolder(String folderName){
        File file=new File(folderName);
        file.mkdirs();
    }

    public void listFiles(String folderName){
        File file=new File(folderName);
        String [] str=file.list();
        for(String fname:str){
            System.out.println(fname);
        }

        //完成路径
        File [] files=file.listFiles();
        for(File file1:files){
            System.out.println(file1);
        }
    }

    public void listAllFiles(String folderName){
        File file=new File(folderName);
        File [] files=file.listFiles();
        for(File file1:files){
            System.out.println(file1);
            if(file1.isDirectory()){
                listAllFiles(file1.getAbsolutePath());
            }
        }
    }

    public boolean isFolder(String filePath){
        File file=new File(filePath);
        if(file.isDirectory()){
            return true;
        }else {
            return false;
        }
    }

    public static void main(String[] args) {
        FileUtil fileUtil=new FileUtil();
        fileUtil.listAllFiles("D://vsrepos");
    }
}
