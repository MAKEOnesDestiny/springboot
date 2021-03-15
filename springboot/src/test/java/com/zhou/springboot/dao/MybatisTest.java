package com.zhou.springboot.dao;

import com.zhou.springboot.model.TestBean;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class MybatisTest {

    @Autowired
    private TimeOutMapper timeOutMapper;

    @Test
    public void testExplain() {
        System.out.println(timeOutMapper.testExplain());
    }

    @Test
    public void testParam() {
        timeOutMapper.testParam(10);
    }

    @Test
    public void testMultiParam() {
        timeOutMapper.testMultiParam(10, "hfzhou");
    }

    @Test
    public void testDate() {
        timeOutMapper.testDate(10, new Date());
    }

    @Test
    public void testBean() {
        TestBean testBean = new TestBean();
        testBean.name = "hfzhou";
        testBean.num = 10;
        timeOutMapper.testBean(testBean);
    }

    @Test
    @Rollback()
    @Transactional
    public void testInsertBean() {
        TestBean testBean1 = new TestBean();
        testBean1.num = 1000;
        testBean1.name = "hfzhou";

        TestBean testBean2 = new TestBean();
        testBean2.num = 2000;
        testBean2.name = "kobe";

        List<TestBean> list = new ArrayList<TestBean>() {{
            add(testBean1);
            add(testBean2);
        }};
        timeOutMapper.patchInsert(list);
    }

    @Test
    @Transactional
    @Rollback
    public void testStatement(){
        timeOutMapper.testDelete();
    }


}
