package com.zhou.springboot.test;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockTest {

    public static void main(String[] args) throws InterruptedException {
        final Lock lock = new ReentrantLock();
        new Thread(()->{
            lock.lock();
        }).start();
        Thread.sleep(1000);
        lock.lock();
    }

}
