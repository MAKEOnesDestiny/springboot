package com.zhou.springboot.easytrans;


import javax.annotation.Resource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EasyTransferTest {

    @Resource
    private EasyTransfer easyTransfer;

    @Test
    public void testTransfer() {
        String oldTable = "auto_update_date_test";
        String newTable = "auto_update_date_test_new";
        easyTransfer.transfer(oldTable, newTable);
    }

}
