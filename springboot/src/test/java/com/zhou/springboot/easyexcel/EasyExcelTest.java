package com.zhou.springboot.easyexcel;

import com.alibaba.excel.EasyExcel;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EasyExcelTest {


    public static void main(String[] args) {
        List<TestBean> data = new ArrayList<>();
        TestBean tb = new TestBean();
        tb.setId("1");
        tb.setName("QB");
        data.add(tb);
        System.out.println(new Date());
        EasyExcel.write("/Users/hfzhou/Desktop/easyexcel测试.xlsx", TestBean.class).sheet("sheetName1").doWrite(data);
        System.out.println(new Date());
    }

}
