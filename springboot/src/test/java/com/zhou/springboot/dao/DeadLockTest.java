package com.zhou.springboot.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DeadLockTest {

    @Autowired
    private TestBiz testBiz;


    @Test
    public void test() {
        new Thread(() -> {
            try {
                testBiz.testDeadLock(1, 2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                testBiz.testDeadLock(2, 1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }


}
