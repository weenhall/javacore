package com.ween.thread.method;

/**
 * Created by ween on 2019/4/18
 */
public class SleepMessages {

    public static void main(String[] args) throws InterruptedException {
        String names []={"张三","李四","王五","赵六"};
        for(int i=0;i<names.length;i++){
            Thread.sleep(2000);
            System.out.println(names[i]);
        }
    }
}
