package com.ween.thread;

/**
 * Created by wen on 2018/3/22
 */
public class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("线程正在执行");
    }

    public static void main(String[] args) {
        for(int i=0;i<10;i++){
            MyThread myThread=new MyThread();
            myThread.start();
            System.out.println("当前线程"+myThread.getId());
        }
    }
}
