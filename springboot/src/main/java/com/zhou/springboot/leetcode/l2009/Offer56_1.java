package com.zhou.springboot.leetcode.l2009;

import java.util.Arrays;

public class Offer56_1 {

    //剑指 Offer 56 - I. 数组中数字出现的次数
    //一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。
    //执行用时：
    //2 ms
    //, 在所有 Java 提交中击败了
    //97.12%
    //的用户
    //内存消耗：
    //40.4 MB
    //, 在所有 Java 提交中击败了
    //70.93%
    //的用户
    static class Solution {

        public int[] singleNumbers(int[] nums) {
            int res = 0;
            int i = 0;
            while (i < nums.length) {
                res ^= nums[i++];
            }
            int t = res;
            int high = 1;
            while (t > 1) {
                t /= 2;
                high *= 2;
            }
            int a = 0;
            int b = 0;
            i = 0;
            while (i < nums.length) {
                if ((nums[i] & high) != high) {
                    a ^= nums[i++];
                } else {
                    b ^= nums[i++];
                }
            }
            return new int[]{a, b};
        }

    }

    public static void main(String[] args) {
        Arrays.stream(new Solution().singleNumbers(new int[]{1,2,5,2})).forEach((t) -> {
            System.out.println(t);
        });
    }

}
