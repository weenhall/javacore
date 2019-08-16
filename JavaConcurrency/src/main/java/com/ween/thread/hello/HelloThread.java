package com.ween.thread.hello;

/**
 * Created by ween on 2019/4/18
 */
public class HelloThread extends Thread {
    private String name;
    public HelloThread(String name){
        this.name=name;
    }
    @Override
    public void run() {
        System.out.println("Hello from a thread:"+name);
    }

    public static void main(String args[]) {
       HelloThread a=new HelloThread("A");
       HelloThread b=new HelloThread("B");
       a.start();
       b.start();
    }
}
