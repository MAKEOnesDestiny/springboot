package com.zhou.springboot.multithread.threadname;

/**
 * Thread.currentThread().getName()和this.getName()的区别测试
 *
 * 第1章、Java多线程技能 P18
 * @author zhou
 * @date 2018-6-28
 */
public class ThisTest {

    public static class RunClass extends Thread{

        public void getThis(){
            System.out.println(this.hashCode());
        }

        @Override
        public void run() {
            super.run();
            System.out.println(this.hashCode());
        }
    }

    public static void main(String[] args){
        RunClass runClass = new RunClass();
        Thread t1 = new Thread(runClass);
        runClass.getThis();
        t1.start();
        System.out.println("t1"+t1.hashCode());
    }

}
