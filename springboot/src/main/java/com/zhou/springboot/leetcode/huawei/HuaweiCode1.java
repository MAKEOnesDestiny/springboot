package com.zhou.springboot.leetcode.huawei;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class HuaweiCode1 {

    public void test() {

        //        int[] ss = new int[]{0,1,0,1,0,1,0};
        Scanner in = new Scanner(System.in);
        List<Integer> list = new ArrayList();
        while (in.hasNextInt()) {
            list.add(in.nextInt());
        }
        System.out.println(list);
        String maxS = "";
        int prev = 0;
        boolean valid = true;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            int a = list.get(i);
            if (a == 0 && prev == 0) {
                if (valid && sb.length() > maxS.length() && sb.length() > 1) {
                    maxS = sb.toString();
                }
                sb = new StringBuilder();
                valid = true;
            } else if (prev == 0 && a == 1) {
                prev = 1;
            } else if (prev == 1 && a == 0) {
                prev = 0;
            } else if (prev == 1 && a == 1) {
                valid = false;
            }
            sb.append(a);
        }
        if (valid && sb.length() > maxS.length() && sb.length() > 1) {
            maxS = sb.toString();
        }
        System.out.println(maxS);
    }

}
