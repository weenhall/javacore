package com.ween.thread;

/**
 * Created by ween on 2019/4/18
 */
public class SimpleThreads {

    static void threadMessage(String message){
        String threadName=Thread.currentThread().getName();
        System.out.format("%s: %s%n",threadName,message);
    }

    private static class MessageLoop implements Runnable{
        @Override
        public void run() {
            String names []={"张三","李四","王五","赵六"};
            try{
                for (int i = 0; i <names.length ; i++) {
                    Thread.sleep(2000);
                    threadMessage(names[i]);
                }
            }catch (InterruptedException e){
                threadMessage("未成功");
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        long patience=1000*60*60;
        threadMessage("开始线程");
        long startTime=System.currentTimeMillis();
        Thread t=new Thread(new MessageLoop());
        t.start();

        threadMessage("等待线程执行完毕");

        while (t.isAlive()){
            threadMessage("线程还在执行中");
            t.join(1000);
            if((System.currentTimeMillis()-startTime)>patience&&t.isAlive()){
                threadMessage("线程执行太久了");
                t.interrupt();
                t.join();
            }
        }
        threadMessage("线程执行完毕");
    }

}
