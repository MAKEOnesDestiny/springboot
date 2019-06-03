package com.zhou.springboot.multithread.stopthread;

/**
 * 终端线程测试
 * 第1章、Java多线程技能 P29
 *
 * @author zhou
 * @date 2018-7-10
 */
public class StopThreadTest2 extends Thread{

    @Override
    public void run() {
        super.run();
        try{
            for(int i=0;i<10000;i++){
                if(this.isInterrupted()){
                    System.out.println("检测到线程已被中断");
                    throw new InterruptedException();
                }
                System.out.println("i="+i);
            }
        }catch (Exception e){
            System.out.println("catch捕捉到中断");
            e.printStackTrace();
        }

    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new StopThreadTest2();
        thread.start();
        thread.sleep(50);
        thread.interrupt();
    }

}
