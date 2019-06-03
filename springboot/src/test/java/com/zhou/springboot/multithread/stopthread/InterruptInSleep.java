package com.zhou.springboot.multithread.stopthread;

/**
 * <p>
 * 第1章、Java多线程技能 P30
 *
 * @author zhou
 * @date 2018-7-11
 */
public class InterruptInSleep extends Thread{

    @Override
    public void run() {
        super.run();
        System.out.println("thread开始执行...");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            System.out.println("进入异常终端"+this.isInterrupted());
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        InterruptInSleep thread = new InterruptInSleep();
        thread.start();
        thread.interrupt();
    }

}
