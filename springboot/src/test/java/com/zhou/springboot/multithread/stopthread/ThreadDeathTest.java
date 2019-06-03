package com.zhou.springboot.multithread.stopthread;

/**
 * <p>
 * 第1章、Java多线程技能 P32
 *
 * @author zhou
 * @date 2018-7-11
 */
public class ThreadDeathTest extends Thread{

    @Override
    public void run() {
        super.run();
        try{
            this.stop();
        }catch (ThreadDeath threadDeath){
            System.out.println("ThreadDeath异常");
        }

    }

    public static void main(String[] args){
        ThreadDeathTest thread = new ThreadDeathTest();
        thread.start();
    }

}
