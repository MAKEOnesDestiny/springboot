package com.zhou.springboot.leqee;

import com.zhou.springboot.bean.HasbaniSynsLog;
import com.zhou.springboot.dao.TimeOutMapper;
import java.util.List;
import javax.annotation.Resource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LeqeeTest {

    @Resource
    private TimeOutMapper timeOutMapper;

    @Test
    public void test1() {
        List<String> res = timeOutMapper.selectLog("bi_sku", 1);
        System.out.println(res);
    }

}
