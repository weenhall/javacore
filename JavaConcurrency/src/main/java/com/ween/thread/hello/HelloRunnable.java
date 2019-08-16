package com.ween.thread.hello;

/**
 * Created by ween on 2019/4/18
 */
public class HelloRunnable implements Runnable {
    private String name;
    public HelloRunnable(String name){
        this.name=name;
    }
    @Override
    public void run() {
        System.out.println("Hello from a thread:"+name);
    }

    public static void main(String[] args) {
        HelloRunnable a=new HelloRunnable("A");
        HelloRunnable b=new HelloRunnable("B");
        Thread thread1=new Thread(a);
        Thread thread2=new Thread(b);
        thread1.start();
        thread2.start();
    }
}
