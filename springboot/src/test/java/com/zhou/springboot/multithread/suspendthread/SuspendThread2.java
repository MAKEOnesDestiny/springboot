package com.zhou.springboot.multithread.suspendthread;

/**
 * <p>
 * 第1章、Java多线程技能 P38
 *
 * @author zhou
 * @date 2018-7-11
 */
public class SuspendThread2 extends Thread{

//    private SyncObject syncObject;

    static class SyncObject{

        public synchronized void printString(){
            System.out.println("begin");
            if(Thread.currentThread().getName().equals("a")){
                //如果线程名称为a
                System.out.println("线程a永远suspend");
                Thread.currentThread().suspend();
            }
            System.out.println("end");
        }

    }

    public static void main(String[] args) throws InterruptedException {
        SyncObject syncObject = new SyncObject();
        Thread thread1 = new Thread( new Runnable() {
            @Override
            public void run() {
                syncObject.printString();
            }
        },"a");
        thread1.start();
        Thread.sleep(200);

        Thread thread2 = new Thread( new Runnable() {
            @Override
            public void run() {
                System.out.println("printString的锁一直未被释放");
                syncObject.printString();
            }
        },"b");
        thread2.start();

    }

}
