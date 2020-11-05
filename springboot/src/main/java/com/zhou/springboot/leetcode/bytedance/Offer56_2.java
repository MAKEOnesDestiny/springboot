package com.zhou.springboot.leetcode.bytedance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Offer56_2 {

    static class Solution {

        public int[][] merge(int[][] intervals) {
            Arrays.sort(intervals, (t1, t2) -> {
                return t1[0] - t2[0];
            });
            int[] last = null;
            List<int[]> res = new ArrayList<>();
            for (int[] n : intervals) {
                if (last == null) {
                    last = n;
                } else {
                    if (last[1] < n[0]) {
                        res.add(last);
                        last = n;
                    } else if (last[1] > n[0]) {
                        last[1] = Math.max(n[1], last[1]);
                        last[0] = Math.min(n[0], last[0]);
                    } else {
                        last[1] = n[1];
                    }
                }
            }
            if (last != null) {
                res.add(last);
            }
            int[][] intRes = new int[res.size()][2];
            int[] i = new int[1];
            res.stream().forEach((t) -> {
                intRes[i[0]++] = t;
            });
            return intRes;
        }
    }


    public static void main(String[] args) {
        int[][] in = new int[][]{{1, 4}, {0, 0}};
        int[][] res = new Solution().merge(in);
        System.out.println();
    }

}
