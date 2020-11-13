package com.zhou.springboot.leetcode.bytedance;

import java.util.Arrays;

public class RealCode1 {

    public static class Solution {

        public long get(int[] a, int[] b, int target) {
            Arrays.sort(a);
            Arrays.sort(b);
            long count = 0;
            for (int i = 0; i < a.length; i++) {
                int j = 0;
                for (; j < b.length; j++) {
                    if (a[i] + b[j] >= target) {
                        break;
                    }
                }
                count += (b.length - j);
            }
            return count;
        }
    }


    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 3};
        int[] b = new int[]{4, 5, 6};
        System.out.println(new Solution().get(a, b, 7));
    }

}
