package com.zhou.springboot.multithread.stopthread;

/**
 * 线程停止测试
 * <p>
 * 第1章、Java多线程技能 P24
 *
 * @author zhou
 * @date 2018-6-28
 */
public class ThreadDemo extends Thread {

    @Override
    public void run() {
        super.run();
        for (int i = 0; i < 50000; i++) {
            System.out.println("i=" + (i + 1));
        }
    }

    public static class RunClass {
        public static void main(String[] args) {
            ThreadDemo threadDemo = new ThreadDemo();
            threadDemo.start();
            try{
                Thread.sleep(1);
            }catch (Exception e){
                e.printStackTrace();
            }
            threadDemo.interrupt();
        }
    }
}
