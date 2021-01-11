package com.zhou.springboot.dao;

import com.zhou.springboot.mybatis.config.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TestBiz {

    @Autowired
    private TimeOutMapper timeOutMapper;

    public static final Long sleep = 3000L;

    @DataSource("presto")
    public void testPresto(){
        Integer res = timeOutMapper.testPresto();
        System.out.println(res);
    }


//    @Transactional
    public void testDeadLock(Integer id1, Integer id2) throws InterruptedException {
        System.out.println(Thread.currentThread() + "｜开始id:" + id1);
        timeOutMapper.updateById(id1);
        System.out.println(Thread.currentThread() + "｜结束id:" + id1);

        Thread.sleep(sleep);

        System.out.println(Thread.currentThread() + "｜开始id:" + id2);
        timeOutMapper.updateById(id2);
        System.out.println(Thread.currentThread() + "｜结束id:" + id2);
    }

//    @Transactional
    public void doRename1() throws InterruptedException {
        //todo: 此时宕机需要进行保护
        timeOutMapper.rename("time_out","time_out_temp"); //隐式commit
        System.out.println("原表重命名");

        Thread.sleep(6000L); //模拟数据迁移

        timeOutMapper.rename("time_out_temp","time_out");
        System.out.println("原表重新出现");
    }

//    @Transactional
    public void doRename() throws InterruptedException {
        Thread.sleep(6000L); //模拟数据迁移
        //数据迁移在之前就完成了
        timeOutMapper.unlockTable(); //此锁和rename锁
        System.out.println("释放锁成功");

        //todo: 这个间隙会有一些数据不一致的情况出现

        timeOutMapper.rename("time_out","time_out_temp");
        System.out.println("原表重命名");

        timeOutMapper.rename("time_out_temp","time_out");
        System.out.println("原表重新出现");
    }

}
