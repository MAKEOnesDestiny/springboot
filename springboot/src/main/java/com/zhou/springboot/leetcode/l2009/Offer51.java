package com.zhou.springboot.leetcode.l2009;

//剑指 Offer 51. 数组中的逆序对
//在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。
//[7,5,6,4]  -->  5
public class Offer51 {

    //超过时间限制
    static class Solution {

        public int reversePairs(int[] nums) {
            int count = 0;
            for (int i = nums.length - 2; i >= 0; i--) {
                int j = i;
                while (j < nums.length - 1 && nums[j] > nums[j + 1]) {
                    swap(nums, j, j + 1);
                    j++;
                    count++;
                }
            }
            return count;
        }

        public void swap(int[] nums, int m, int n) {
            int temp = nums[m];
            nums[m] = nums[n];
            nums[n] = temp;
        }

    }

    //归并解法
    //执行用时:46 ms, 在所有 Java 提交中击败了11.09%的用户
    //内存消耗:49 MB, 在所有 Java 提交中击败了5.16%的用户
    //时间复杂度O(nlogn)
    static class Solution2 {

        int count = 0;

        public int reversePairs(int[] nums) {
            sort(nums, 0, nums.length - 1);
            return count;
        }

        public void sort(int[] nums, int l, int r) {
            int mid = (l + r) / 2;
            if (l < r) {
                sort(nums, l, mid);
                sort(nums, mid + 1, r);
                merge(nums, l, mid, r);
            }
        }

        public void merge(int[] nums, int l, int m, int r) {
            int[] temp = new int[r - l + 1];
            int i = l;
            int j = m + 1;
            int index = 0;
            while (i <= m && j <= r) {
                if (nums[i] > nums[j]) {
                    count += (r - j + 1);
                    temp[index++] = nums[i++];
                } else {
                    temp[index++] = nums[j++];
                }
            }
            while (i <= m) {
                temp[index++] = nums[i++];
            }
            while (j <= r) {
                temp[index++] = nums[j++];
            }
            for (int k = 0; k < temp.length; k++) {
                nums[k + l] = temp[k];
            }
        }

    }


    public static void main(String[] args) {
        int[] nums = new int[]{7, 5, 6, 4};
        System.out.println(new Solution2().reversePairs(nums));
       /* Arrays.stream(nums).forEach((t) -> {
            System.out.println(t);
        });*/
    }

}
