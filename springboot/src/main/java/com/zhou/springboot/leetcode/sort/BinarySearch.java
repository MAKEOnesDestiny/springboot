package com.zhou.springboot.leetcode.sort;

public class BinarySearch {

    public static class Solution {

        /**
         * 二分查找
         *
         * @param n int整型 数组长度
         * @param v int整型 查找值
         * @param a int整型一维数组 有序数组
         * @return int整型
         */
        public int upper_bound_(int n, int v, int[] a) {
            if (v > a[n - 1]) {
                return n + 1;
            }
            // write code here
            int min = 0;
            int max = n - 1;
            int mid = (min + max) / 2;
            while (min < max) {
                if (a[mid] < v) {
                    min = mid + 1;
                    mid = (min + max) / 2;
                } else if (a[mid] > v) {
                    max = mid;
                    mid = (min + max) / 2;
                } else {
                    //found
                    break;
                }
            }
            while (mid > 0) {
                if (a[mid - 1] == a[mid]) {
                    mid--;
                } else {
                    break;
                }
            }
            return mid + 1;
        }
    }


}
