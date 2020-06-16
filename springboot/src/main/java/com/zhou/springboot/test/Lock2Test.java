package com.zhou.springboot.test;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Lock2Test {

    public static void main(String[] args) {
        ReadWriteLock rwLock = new ReentrantReadWriteLock();
        new Thread(()->{
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            rwLock.writeLock().lock();
            System.out.println(111111);
        }).start();
        rwLock.readLock().lock();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        rwLock.readLock().unlock();
    }


}
