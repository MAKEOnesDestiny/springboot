package com.zhou.springboot.leetcode.bytedance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Code15_new {

    static class Solution {

        public List<List<Integer>> threeSum(int[] nums) {
            Arrays.sort(nums);
            List<List<Integer>> result = new ArrayList<>();

            int i = 0;
            int n = nums.length - 1;
            if (nums.length == 3) {
                if (nums[0] + nums[1] + nums[2] == 0) {
                    add(result, nums[0], nums[1], nums[2]);
                    return result;
                }
            }
            for (; i < nums.length - 2; i++) {
                if (nums[i] > 0) {
                    //如果最小的大于0，则不可能加起来为0
                    continue;
                }
                if (i > 0 && nums[i - 1] == nums[i]) {
                    continue;
                }
                int j = i + 1;
                int k = n;
                while (j < k) {
                    if (nums[i] + nums[k] + nums[j] > 0) {
                        k--;
                    } else if (nums[i] + nums[k] + nums[j] < 0) {
                        j++;
                    } else {
                        add(result, nums[i], nums[j], nums[k]);
                        j++;
                        k--;
                        while (j < k && nums[j] == nums[j - 1]) {
                            j++;
                        }
                        while (j < k && nums[k] == nums[k + 1]) {
                            k--;
                        }
                    }
                }
            }
            return result;
        }

        public void add(List<List<Integer>> result, int i, int j, int k) {
            List<Integer> single = new ArrayList<>();
            single.add(i);
            single.add(j);
            single.add(k);
            result.add(single);
        }
    }


    public static void main(String[] args) {
        //        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        //        int[] nums = new int[]{-2, 0, 1, 1, 2};
        int[] nums = new int[]{0, 0, 0};
        List<List<Integer>> result = new Code15_new.Solution().threeSum(nums);
        System.out.println(result);
    }


}
