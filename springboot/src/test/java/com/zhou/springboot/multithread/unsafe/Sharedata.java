package com.zhou.springboot.multithread.unsafe;

/**
 * 多线程共享变量并发测试
 * <p>
 * 第1章、Java多线程技能 P11
 *
 * Note:
 *  此程序无法保证线程安全
 *
 * @author zhou
 * @date 2018-6-27 0:21
 */
public  class  Sharedata extends Thread {

    private  Integer count = 5;

    @Override
    public void run() {
        super.run();
        synchronized (count) {      //count改成this保证线程安全
            count--;
            System.out.println("线程" + Thread.currentThread() + "中的count值为: " + count);
        }
    }

    public static void main(String[] args) {
        Sharedata sharedata = new Sharedata();
        Thread threadA = new Thread(sharedata, "A");
        Thread threadB = new Thread(sharedata, "B");
        Thread threadC = new Thread(sharedata, "C");
        Thread threadD = new Thread(sharedata, "D");
        Thread threadE = new Thread(sharedata, "E");
        threadA.start(); // 3 1 0 3 0
        threadB.start();
        threadC.start();
        threadD.start();
        threadE.start();
    }

}
