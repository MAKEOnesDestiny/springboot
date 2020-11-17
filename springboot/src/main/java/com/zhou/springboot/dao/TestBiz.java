package com.zhou.springboot.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TestBiz {

    @Autowired
    private TimeOutMapper timeOutMapper;

    public static final Long sleep = 3000L;

    @Transactional
    public void testDeadLock(Integer id1, Integer id2) throws InterruptedException {
        System.out.println(Thread.currentThread() + "｜开始id:" + id1);
        timeOutMapper.updateById(id1);
        System.out.println(Thread.currentThread() + "｜结束id:" + id1);

        Thread.sleep(sleep);

        System.out.println(Thread.currentThread() + "｜开始id:" + id2);
        timeOutMapper.updateById(id2);
        System.out.println(Thread.currentThread() + "｜结束id:" + id2);
    }


}
