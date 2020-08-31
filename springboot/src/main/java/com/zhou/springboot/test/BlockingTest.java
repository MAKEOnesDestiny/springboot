package com.zhou.springboot.test;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class BlockingTest {

    public static void main(String[] args) throws InterruptedException {
        LinkedBlockingQueue<Integer> b = new LinkedBlockingQueue(1);
        b.put(1);
        b.put(2);

        new Thread(()->{
            try {
                b.put(1);
                b.put(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).run();


    }

}
