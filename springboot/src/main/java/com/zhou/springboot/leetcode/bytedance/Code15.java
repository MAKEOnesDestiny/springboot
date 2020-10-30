package com.zhou.springboot.leetcode.bytedance;

import java.util.ArrayList;
import java.util.List;

/**
 * 耗时长
 * 没做出来
 */
public class Code15 {

    //给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
    @SuppressWarnings("all")
    static class Solution {

        public List<List<Integer>> threeSum(int[] nums) {
            if (nums.length == 0) {
                return new ArrayList<>();
            }
            sort(nums, 0, nums.length - 1);
            int pos = nums.length - 1;
            int neg = 0;
            List<List<Integer>> result = new ArrayList<>();
            while (pos > neg) {
                int ab = nums[pos] + nums[neg];
                if (ab > 0) {
                    boolean found = false;
                    for (int i = neg + 1; i < pos && nums[i] < 0; i++) {
                        if (ab + nums[i] == 0) {
                            List singleList = new ArrayList<>();
                            singleList.add(nums[pos]);
                            singleList.add(nums[neg]);
                            singleList.add(nums[i]);
                            result.add(singleList);
                            pos--;
                            neg++;
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        pos--;
                    }
                } else if (ab < 0) {
                    boolean found = false;
                    for (int i = pos - 1; i > neg && nums[i] > 0; i--) {
                        if (ab + nums[i] == 0) {
                            List singleList = new ArrayList<>();
                            singleList.add(nums[pos]);
                            singleList.add(nums[neg]);
                            singleList.add(nums[i]);
                            result.add(singleList);
                            pos--;
                            neg++;
                            break;
                        }
                    }
                    if (!found) {
                        neg++;
                    }
                } else {
                    //ab=0
                    for (int i = pos - 1; i > neg && nums[i] >= 0; i--) {
                        if (nums[i] == 0) {
                            List singleList = new ArrayList<>();
                            singleList.add(nums[pos]);
                            singleList.add(nums[neg]);
                            singleList.add(nums[i]);
                            result.add(singleList);
                            break;
                        }
                    }
                    if (nums[neg] <= 0) {
                        neg++;
                    } else if (nums[pos] >= 0) {
                        pos--;
                    }
                }

            }
            return result;
        }

        public void sort(int[] nums, int m, int n) {
            int q = partition(nums, m, n);
            if (q > m) {
                sort(nums, m, q - 1);
            }
            if (q < n) {
                sort(nums, q + 1, n);
            }
        }

        public int partition(int[] nums, int m, int n) {
            int small = m;
            for (int i = m; i < n; i++) {
                if (nums[i] < nums[n]) {
                    swap(nums, small, i);
                    small++;
                }
            }
            swap(nums, small, n);
            return small;
        }

        public void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }

    }

    public static void main(String[] args) {
        //        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        int[] nums = new int[]{-2, 0, 1, 1, 2};
        List<List<Integer>> result = new Solution().threeSum(nums);
        System.out.println(result);
    }


}
