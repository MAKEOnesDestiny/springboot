package com.zhou.springboot.multithread.stopthread;

/**
 * 终端线程测试
 * 第1章、Java多线程技能 P28
 *
 * @author zhou
 * @date 2018-7-10
 */
public class StopThreadTest extends Thread{

    @Override
    public void run() {
        super.run();
        for(int i=0;i<10000;i++){
            if(this.isInterrupted()){
                System.out.println("检测到线程已被中断");
                break;
            }
            System.out.println("i="+i);
        }
        System.out.println("end");
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new StopThreadTest();
        thread.start();
        thread.sleep(50);
        thread.interrupt();
    }

}













