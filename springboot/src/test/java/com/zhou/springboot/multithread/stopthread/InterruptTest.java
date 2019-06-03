package com.zhou.springboot.multithread.stopthread;

/**
 * interrupted和isInterrupted测试
 * <p>
 * 第1章、Java多线程技能 P26
 *
 * @author zhou
 * @date 2018-6-28
 */
public class InterruptTest extends Thread{

    @Override
    public void run() {
        super.run();
        for(int i=0;i<50000;i++){
            System.out.println("i="+(i+1));
        }
        this.interrupt();
           /* try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/
        System.out.println("Thread is interrupted1:"+Thread.interrupted());
        System.out.println("Thread is interrupted2:"+Thread.interrupted());
    }

    public static class RunClass{
        public static void main(String[] args){
            InterruptTest interruptTest = new InterruptTest();
            interruptTest.start();
        }

    }

    public static class RunClass2{
        public static void main(String[] args){
            InterruptTest interruptTest = new InterruptTest();
            interruptTest.start();
            interruptTest.interrupt();
            System.out.println("Thread is interrupted1:"+interruptTest.isInterrupted());
            System.out.println("Thread is interrupted2:"+interruptTest.isInterrupted());
        }

    }

}
