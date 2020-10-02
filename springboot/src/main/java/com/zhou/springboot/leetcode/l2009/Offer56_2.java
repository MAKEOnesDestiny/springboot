package com.zhou.springboot.leetcode.l2009;

public class Offer56_2 {

    //剑指 Offer 56 - II. 数组中数字出现的次数 II
    //在一个数组 nums 中除一个数字只出现一次之外，其他数字都出现了三次。请找出那个只出现一次的数字。
    //nums = [3,4,3,3]
    static class Solution {

        //执行用时：
        //6 ms
        //, 在所有 Java 提交中击败了
        //72.29%
        //的用户
        //内存消耗：
        //39.6 MB
        //, 在所有 Java 提交中击败了
        //91.90%
        //的用户
        public int singleNumber(int[] nums) {
            int[] res = new int[32];
            int i = 0;
            int index = 0;
            for (int j = 0; j < nums.length; j++) {
                i = nums[j];
                index = 0;
                while (i > 0) {
                    res[index++] += i & 0x01;
                    i = i >> 1;
                }
            }
            int found = 0;
            int f = 1;
            for (int j = 0; j < res.length; j++) {
                found += (res[j] % 3) * f;
                f <<= 1;
            }
            return found;
        }

        public static void main(String[] args) {
            System.out.println(new Solution().singleNumber(new int[]{3, 4, 3, 3}));
        }

    }

}
