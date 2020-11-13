package com.zhou.springboot.leetcode.bytedance;

import java.util.Arrays;

public class RealCode2 {

    /**
     * 1243--》找到比他大并且最接近他的数字 当时没做出来T.T
     */
    public static class Solution {

        public int process(int num) {
            int length = 1;
            int offset = 10;
            while (num / offset > 0) {
                length++;
                offset *= 10;
            }
            int[] nums = new int[length];
            int i = 0;
            while (num > 0) {
                nums[i] = num % 10;
                num /= 10;
                i++;
            }

            i = 0;
            while (i < length) {
                int j = i + 1;
                while (j < length) {
                    if (nums[j] < nums[i]) {
                        break;
                    }
                    j++;
                }
                if (j == length) {
                    //not found
                    i++;
                } else {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                    Arrays.sort(nums, 0, j);
                    break;
                }
            }

            int res = 0;
            offset = 1;
            for (int j = 0; j < nums.length; j++) {
                res += (offset * nums[j]);
                offset *= 10;
            }
            return res;
        }

    }

    public static void main(String[] args) {
        System.out.println(new Solution().process(13241));
        int a[] = new int[]{4, 3, 2, 1};
        Arrays.sort(a);
        System.out.println();
    }


}
