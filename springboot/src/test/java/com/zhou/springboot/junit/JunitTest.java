package com.zhou.springboot.junit;

import com.zhou.springboot.bean.TimeOut;
import com.zhou.springboot.dao.OgnlBean;
import com.zhou.springboot.dao.TimeOutMapper;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JunitTest {

    @Autowired
    private TimeOutMapper timeOutMapper;

    @Before
    public void before() {
        System.out.println("我是before代码");
    }

    @Test
    public void testTable() {
        System.out.println(timeOutMapper.selectTestTable());
    }

    @Test
    public void testTable2() {
        String sql = "select count(1) from test.test_table where id=${id}";
        System.out.println(timeOutMapper.testCdata(sql, 1L, null));
    }

    @Test
    public void testTable3() {
        String sql = "select count(1) from test.test_table where id=${id}";
        OgnlBean bean = new OgnlBean();
        bean.setId(3);
        System.out.println(timeOutMapper.testCdata(sql, 1L, bean));
    }

    @Test
    public void testExplain() {
        System.out.println(timeOutMapper.testExplain());
    }


    @Test
    public void testTkMybatis() {
        TimeOut to = new TimeOut();
        to.setId(1);
        TimeOut res = timeOutMapper.selectOne(to);
        System.out.println(res);
    }


    @After
    public void after() {
        System.out.println("我是after代码");
    }

}
















