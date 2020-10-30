package com.zhou.springboot.leetcode.bytedance;

public class Code53 {

    static class Solution {

        public int maxSubArray(int[] nums) {
            int max = nums[0];
            int sum = nums[0];
            int i = 0;
            int j = 0;
            while (i < nums.length && j < nums.length) {
                if (i == j) {
                    j++;
                }else if(i<j){
                    i++;
                }
                while (j < nums.length && nums[j] < 0 ) {
                    sum += nums[j];
                    j++;
                }
                while (i < j && nums[i] < 0) {
                    sum -= nums[i];
                    i++;
                }
                max = Math.max(max, sum);
            }
            return max;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(new Solution().maxSubArray(nums));
    }

}
