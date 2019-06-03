package com.zhou.springboot.multithread.threadname;

/**
 * 线程名测试
 *
 * 第1章、Java多线程技能 P17
 * @author zhou
 * @date 2018-6-28
 */
public class CountOperate extends Thread{

    public CountOperate(){
        System.out.println("CountOperate---start");
        String cName = Thread.currentThread().getName();
        System.out.println("Thread.currentThread.getName()=" + cName);
        String name = this.getName();
        System.out.println("this.getName()=" + name);
        System.out.println("CountOperate---end");
    }

    @Override
    public void run() {
        super.run();
        System.out.println("run---start");
        String cName = Thread.currentThread().getName();
        System.out.println("Thread.currentThread.getName()=" + cName);
        String name = this.getName();
        System.out.println("this.getName()=" + name);
        System.out.println("run---end");
    }

    public static class Run{

        public static void main(String[] args){
            CountOperate countOperate = new CountOperate();

            Thread thread = new Thread(countOperate);
            thread.setName("A");
            thread.start();
        }

    }

}
