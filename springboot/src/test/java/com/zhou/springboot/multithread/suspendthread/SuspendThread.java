package com.zhou.springboot.multithread.suspendthread;

import lombok.Data;
/**
 * <p>
 * 第1章、Java多线程技能 P36
 *
 * @author zhou
 * @date 2018-7-11
 */
@Data
public class SuspendThread extends Thread{

    private long i;

    @Override
    public void run() {
        super.run();
        while(true){
            i++;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        SuspendThread thread = new SuspendThread();
        thread.start();
        Thread.sleep(5000);

        thread.suspend();
        System.out.println("time1="+System.currentTimeMillis()+" i="+thread.getI());
        Thread.sleep(5000);
        System.out.println("time1="+System.currentTimeMillis()+" i="+thread.getI());
        thread.resume();
        Thread.sleep(5000);
        thread.suspend();
        System.out.println("time2="+System.currentTimeMillis()+" i="+thread.getI());
        Thread.sleep(5000);
        System.out.println("time2="+System.currentTimeMillis()+" i="+thread.getI());
        thread.resume();
    }

}
