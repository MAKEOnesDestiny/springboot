package com.zhou.springboot.elasticsearch;

import java.util.ArrayList;
import java.util.List;

public class RamUsageEstimatorTest {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 10000000; i++) {
            list.add(new String("1234567890"));
        }
        //浅预测
        long used = RamUsageEstimator.shallowSizeOf(list);
        System.out.println(RamUsageEstimator.humanReadableUnits(used));
    }

}
