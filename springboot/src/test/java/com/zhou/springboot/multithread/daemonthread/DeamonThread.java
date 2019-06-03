package com.zhou.springboot.multithread.daemonthread;

/**
 * <p>
 * 第1章、Java多线程技能 P50
 *
 * @author zhou
 * @date 2018-7-16
 */
public class DeamonThread extends Thread{

    @Override
    public void run() {
        super.run();
        while(true){
            int i = 0;
            System.out.println("i="+(++i));
            try {
                this.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        DeamonThread thread = new DeamonThread();
        thread.setDaemon(true);
        thread.start();
        Thread.sleep(5000);
        System.out.println("main exit...");
    }

}
