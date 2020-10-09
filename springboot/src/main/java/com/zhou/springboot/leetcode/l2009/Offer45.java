package com.zhou.springboot.leetcode.l2009;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

//剑指 Offer 45. 把数组排成最小的数
public class Offer45 {

    //执行用时：
    //14 ms
    //, 在所有 Java 提交中击败了
    //12.22%
    //的用户
    //内存消耗：
    //38.6 MB
    //, 在所有 Java 提交中击败了
    //50.70%
    //的用户
    class Solution {

        public String minNumber(int[] nums) {
            List<Integer> list = new ArrayList<>(Arrays.stream(nums).boxed().collect(Collectors.toList()));
            list.sort((o1, o2) -> ("" + o1 + o2).compareTo("" + o2 + o1));
            String s = "";
            for (int i = 0; i < list.size(); i++) {
                s += list.get(i);
            }
            return s;
        }


    }

}
