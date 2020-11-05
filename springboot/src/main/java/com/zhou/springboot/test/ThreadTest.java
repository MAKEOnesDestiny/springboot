package com.zhou.springboot.test;

import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadTest {

    static {
        System.out.println("我是ThreadTest静态快的方法");
    }

    public static void main(String[] args) {
        new Thread(() -> {
            try {
                Thread.sleep(100000000);
            } catch (InterruptedException e) {
            }
        }, "sleeping-thread").start(); //休眠

        new Thread(() -> {
            LockSupport.park();
        }, "park-thread").start(); //驻留

        ReentrantLock reentrantLock = new ReentrantLock();
        reentrantLock.lock();
        new Thread(() -> {
            reentrantLock.lock();
        }, "lock-thread").start();

    /*    Object lock = new Object();
        synchronized (lock) {
            new Thread(() -> {

                synchronized (lock) {
                    while (true) {
                        ;
                    }
                }
            }, "synchronized-thread").start();
            while(true);
        }*/
        Object lock = new Object();
        new Thread(() -> {

            synchronized (lock) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                }
            }
        }, "wait-thread").start();

    }


}
