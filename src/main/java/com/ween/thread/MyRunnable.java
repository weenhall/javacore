package com.ween.thread;

/**
 * Created by wen on 2018/3/22
 */
public class MyRunnable implements Runnable {
    public void run() {
        System.out.println("Ruannable线程对象正在执行");
    }

    public static void main(String[] args) {
        for(int i=0;i<10;i++){
            Thread thread=new Thread(new MyRunnable());
            thread.start();
            System.out.println("当前线程"+thread.getId());
        }
    }
}
