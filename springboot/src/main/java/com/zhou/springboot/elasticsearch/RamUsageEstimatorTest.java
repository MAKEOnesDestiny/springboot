package com.zhou.springboot.elasticsearch;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;

public class RamUsageEstimatorTest {

    public static void main(String[] args) throws InterruptedException {
        //        Thread.sleep(5000L);   //线程休眠5s
        List<String> ss = new ArrayList<>();

        long used = 0L;
        System.out.println(new Date());
        for (int i = 0; i < 10000000; i++) {
            String s = RandomStringUtils.randomAlphanumeric(10);
            used += RamUsageEstimator.sizeOfString(s); //一千万个数据
            ss.add(s);
        }
        System.out.println(RamUsageEstimator.humanReadableUnits(used));
        System.out.println(new Date());

        System.gc();
        Thread.sleep(3000L);
        ss.clear();
        System.out.println("reference clear");
        Thread.sleep(3000L);
        System.gc();
        System.out.println("gc finish");
        while (true) {
            Thread.sleep(20000L);
        }
    }

    @Test
    public void estimateString() {
        long used = 0L;
        System.out.println(new Date());
        for (int i = 0; i < 10000000; i++) {
            used += RamUsageEstimator.shallowSizeOf(new String("1234567890")); //耗时主要是在反射上
        }
        System.out.println(RamUsageEstimator.humanReadableUnits(used)); //耗时5s
        System.out.println(new Date());
    }

    public void estimateList() {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 10000000; i++) {

            list.add(new String("1234567890"));
        }
        //浅预测
        long used = RamUsageEstimator.shallowSizeOf(list);
        System.out.println(RamUsageEstimator.humanReadableUnits(used));
    }

}
