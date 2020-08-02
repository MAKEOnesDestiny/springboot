package com.zhou.springboot.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Leetcode7 {

    //剑指 Offer 14- I. 剪绳子
    //超出时间限制
    static class Solution1 {

        public int rec(int n) {
            if (n <= 3) {
                return n;
            }
            int max = 0;
            for (int i = 1; i <= (n + 1) / 2; i++) {
                max = Math.max(max, rec(n - i) * i);
            }
            return max;
        }

        public int cuttingRope(int n) {
            if (n == 3) {
                return 2;
            }
            if (n == 2) {
                return 1;
            } else {
                return rec(n);
            }
        }
    }

    //动态规划
    static class Solution11 {

        public int cuttingRope(int n) {
            if (n == 2) {
                return 1;
            }
            if (n == 3) {
                return 2;
            }
            int[] sub = new int[n + 1];
            sub[1] = 1;
            sub[2] = 2;
            sub[3] = 3;
            for (int i = 4; i <= n; i++) {
                int max = 0;
                for (int j = 1; j < i; j++) {
                    max = Math.max(max, sub[j] * sub[i - j]);
                }
                sub[i] = max;
            }
            return sub[n];
        }
    }

    //贪婪算法求解
    static class Solution12 {

        public int cuttingRope(int n) {
            int max = 1;
            if (n == 4) {
                return 4;
            }
            if (n == 3) {
                return 2;
            }
            if (n == 2) {
                return 1;
            }
            while (n > 4) {
                max *= 3;
                n -= 3;
            }
            return max * n;
        }
    }

    //买卖股票的最佳时机
    static class Solution2 {

        public int maxProfit(int[] prices) {
            if (prices.length == 0) {
                return 0;
            }
            int min = prices[0];
            int max = 0;
            for (int i = 0; i < prices.length; i++) {
                min = Math.min(min, prices[i]);
                max = Math.max(max, prices[i] - min);
            }
            System.out.println(max);
            return max;
        }
    }

    //BST中第K个大的数字
    static class Solution3 {

        public class TreeNode {

            int val;
            TreeNode left;
            TreeNode right;

            TreeNode() {}

            TreeNode(int val) { this.val = val; }

            TreeNode(int val, TreeNode left, TreeNode right) {
                this.val = val;
                this.left = left;
                this.right = right;
            }
        }

        public int kthLargest(TreeNode root, int k) {
            List<Integer> list = new ArrayList<>();
            if (root != null) {
                recursive(root, list);
                return list.get(list.size() - k);
            } else {
                return 0;
            }
        }

        public void recursive(TreeNode t, List<Integer> list) {
            if (t.left != null) {
                recursive(t.left, list);
            }
            list.add(t.val);
            if (t.right != null) {
                recursive(t.right, list);
            }
        }
    }

    //["h","e","l","l","o"]
    static class Solution {

        public void reverseString(char[] s) {
            char temp;
            for (int i = 0; i < s.length / 2; i++) {
                temp = s[i];
                s[i] = s[s.length - i - 1];
                s[s.length - i - 1] = temp;
            }
        }
    }


    public static void main(String[] args) {
        char[] s = new char[]{'h', 'e', 'l', 'l', 'o'};
        new Solution().reverseString(s);
        System.out.println();
    }


}






























