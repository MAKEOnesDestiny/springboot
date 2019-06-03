package com.zhou.springboot.multithread.threadpriority;

/**
 * <p>
 * 第1章、Java多线程技能 P49
 *
 * @author zhou
 * @date 2018-7-16
 */
public class PriorityTest extends Thread{

    public long count;

    @Override
    public void run() {
        super.run();
        while(true){
            count++;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        PriorityTest thread1 = new PriorityTest();
        PriorityTest thread2 = new PriorityTest();
        thread1.setPriority(1);
        thread2.setPriority(10);

        thread1.start();
        thread2.start();

        Thread.sleep(1000);
        thread1.stop();
        thread2.stop();

        System.out.println("count in thread1 = "+thread1.count);
        System.out.println("count in thread2 = "+thread2.count);
    }

}
