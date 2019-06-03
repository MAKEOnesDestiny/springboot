package com.zhou.springboot.multithread.stopthread;
/**
 * <p>
 * 第1章、Java多线程技能 P32
 *
 * @author zhou
 * @date 2018-7-11
 */
public class ForceStopThread extends Thread{

    private int i;

    @Override
    public void run() {
        super.run();
        while(true){
            i++;
            System.out.println("i="+i);
            try {
                this.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ForceStopThread thread = new ForceStopThread();
        thread.start();
        Thread.sleep(8000);
        thread.stop();
    }


}
