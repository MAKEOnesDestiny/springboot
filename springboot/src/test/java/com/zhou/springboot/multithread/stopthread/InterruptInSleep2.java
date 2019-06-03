package com.zhou.springboot.multithread.stopthread;

/**
 * <p>
 * 第1章、Java多线程技能 P30
 *
 * @author zhou
 * @date 2018-7-11
 */
public class InterruptInSleep2 extends Thread {

    @Override
    public void run() {
        super.run();
        System.out.println("thread开始执行...");
        long begin = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            System.out.println("i=" + i);
        }
        long end = System.currentTimeMillis();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            System.out.println("进入异常终端");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        InterruptInSleep2 thread = new InterruptInSleep2();
//        thread.start();
        thread.run();
        thread.interrupt();
        System.out.println("main方法结束");
    }

}
