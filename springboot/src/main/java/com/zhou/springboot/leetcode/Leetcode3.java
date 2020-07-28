package com.zhou.springboot.leetcode;

public class Leetcode3 {

    //二分查找
    static class Solution {
        public int search(int[] nums, int target) {
            int left = -1;
            int right = nums.length;
            int mid = (left + right) / 2;
            while (nums[mid] != target) {
                if (nums[mid] > target) {
                    right = mid;
                } else {
                    left = mid;
                }
                if((right-left)<=1){
                    return -1;
                }
                mid = (left + right) / 2;
            }
            return mid;
        }
    }

    public static void main(String[] args) {
        new Solution().search(new int[]{-1, 0, 3, 5, 9, 12}, 9);
    }

}
