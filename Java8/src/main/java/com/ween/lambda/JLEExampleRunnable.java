package com.ween.lambda;

/**
 * @author weenhall
 */
public class JLEExampleRunnable {
    public static void main(String[] args) {
        //without lambda,Runnable implementation using anonymous class
        Runnable runnable=new Runnable() {
            @Override
            public void run() {
                System.out.println("Runnable example without lampda exp.");
            }
        };
        Thread thread=new Thread(runnable);
        thread.start();

        //with lambda
        Runnable withLambda=()-> System.out.println("Runnable example with lambda exp.");
        Thread thread1=new Thread(withLambda);
        thread1.start();
    }
}
