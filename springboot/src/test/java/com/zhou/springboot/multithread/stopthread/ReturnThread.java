package com.zhou.springboot.multithread.stopthread;

/**
 * <p>
 * 第1章、Java多线程技能 P36
 *
 * @author zhou
 * @date 2018-7-11
 */
public class ReturnThread extends Thread{

    @Override
    public void run() {
        super.run();
        while(true){
            if(this.isInterrupted()){
                //此线程中断标志位为真
                System.out.println("线程中断");
                return ;
            }
            System.out.println(System.currentTimeMillis());
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ReturnThread thread = new ReturnThread();
        thread.start();
        Thread.sleep(10);
        thread.interrupt();
    }

}
