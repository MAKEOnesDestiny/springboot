package com.zhou.springboot.multithread.suspendthread;

/**
 * <p>
 * 第1章、Java多线程技能 P39
 *
 * @author zhou
 * @date 2018-7-11
 */
public class SuspendThread3 extends Thread{

    private long i;

    @Override
    public synchronized void run() {
        super.run();
        while(true){
            i++;
//            System.out.println(i);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        SuspendThread3 thread = new SuspendThread3();
        thread.start();
        Thread.sleep(2000);
        thread.suspend();
        System.out.println("main end");
    }

}
