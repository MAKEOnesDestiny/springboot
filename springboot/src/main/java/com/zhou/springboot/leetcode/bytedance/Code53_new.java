package com.zhou.springboot.leetcode.bytedance;

//当时没有做出来......
public class Code53_new {

    static class Solution {

        public int maxSubArray(int[] nums) {
            int res = nums[0];
            int sum = 0;
            for (int n : nums) {
                if (sum > 0) {
                    //前面sum>0,则可以拿过来用
                    sum += n;
                } else {
                    //如果前面的sum<0，则不需要前面的sum，是累赘
                    sum = n;
                }
                res = Math.max(res, sum);
            }
            return res;
        }
    }


}
