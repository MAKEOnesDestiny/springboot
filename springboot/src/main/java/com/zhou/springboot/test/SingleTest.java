package com.zhou.springboot.test;


import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class SingleTest {

    public static void main(String[] args) {
        ScheduledExecutorService ss = Executors.newSingleThreadScheduledExecutor();
        CountDownLatch cl = new CountDownLatch(1);
        ss.submit(()->{
            try {
                cl.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(3);
        });
        ss.submit(()->{
            try {
                cl.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(1);
        });
        ss.submit(()->{
            try {
                cl.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(2);
        });
        cl.countDown();
        System.out.println("hadsa");
    }

}
