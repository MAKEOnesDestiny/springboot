package com.zhou.springboot.leetcode.l2009;

//执行用时：
//2 ms
//, 在所有 Java 提交中击败了
//25.70%
//的用户
//内存消耗：
//39.5 MB
//, 在所有 Java 提交中击败了
//97.79%
//的用户
public class Offer29 {

    //输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
    //还可以优化，数据可能是有-1
    static class Solution {

        public int[] spiralOrder(int[][] matrix) {
            int i = 0;
            int j = -1;
            if (matrix.length == 0) {
                return new int[0];
            }
            int sl = matrix[0].length;
            int n = matrix.length;
            int count = 0;
            int[] res = new int[sl * n];
            int l = 0;
            int r = sl - 1;
            int u = 0;
            int d = n - 1;
            int dir = 0;
            while (count < sl * n) {
                if (j < sl - 1 && j < r && dir==0) {
                    j++;
                    if (j == r) {
                        u++;
                        dir = 1;
                    }
                } else if (i < n - 1 && i < d && dir==1) {
                    i++;
                    if (i == d) {
                        r--;
                        dir =2;
                    }
                } else if (j > 0 && j > l && dir == 2) {
                    j--;
                    if (j == l) {
                        d--;
                        dir = 3;
                    }
                } else if (i > 0 && i > u && dir == 3) {
                    i--;
                    if (i == u) {
                        l++;
                        dir = 0;
                    }
                }
                res[count++] = matrix[i][j];
                //                matrix[i][j] = -1;
            }
            return res;
        }
    }

    public static void main(String[] args) {
        //        int[][] nums = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] nums = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        int[] res = new Solution().spiralOrder(nums);
        System.out.println();
    }

}
