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
    static class Solution4 {

        public void reverseString(char[] s) {
            char temp;
            for (int i = 0; i < s.length / 2; i++) {
                temp = s[i];
                s[i] = s[s.length - i - 1];
                s[s.length - i - 1] = temp;
            }
        }
    }

    //反转字符串中的单词 III
    static class Solution5 {

        public String reverseWords(String s) {
            String[] ss = s.split(" ");
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < ss.length; i++) {
                sb.append(new StringBuilder(ss[i]).reverse());
                if (i != ss.length - 1) {
                    sb.append(" ");
                }
            }
            return sb.toString();
        }


    }

    //括号生成-错误做法
    static class Solution60 {

        public List<String> generateParenthesis(int n) {
            List<String> result = new ArrayList<>();
            recursive(n, n, result);
            return result;
        }

        public List<String> recursive(int m, int n, List<String> list) {
            if (m == 1) {
                return new ArrayList<String>() {{
                    add("()");
                }};
            }
            for (int i = 1; i < m; i++) {
                String left = "";
                String right = "";
                for (int j = 0; j < i; j++) {
                    left += "(";
                    right += ")";
                }
                List<String> sub = recursive(m - i, n, list);
                if (m == n) {
                    for (String ss : sub) {
                        list.add(left + right + ss);
                        list.add(left + ss + right);
                    }
                    continue;
                } else {
                    List<String> moreSub = new ArrayList<>();
                    for (int j = 0; j < sub.size(); j++) {
                        moreSub.add(left + right + sub.get(j));
                        moreSub.add(left + sub.get(j) + right);
                    }
                    return moreSub;
                }
            }
            return new ArrayList<String>();
        }
    }

    //括号生成
    static class Solution61 {

        public List<String> generateParenthesis(int n) {
            List<String> list = new ArrayList<>();
            recursive("", 0, 0, n, list);
            return list;
        }

        public void recursive(String s, int i, int j, int n, List<String> list) {
            if (i > n || j > n || i < j) {
                return;
            }
            if (i == n && j == n) {
                list.add(s);
                return;
            }
            recursive(s + "(", i + 1, j, n, list);
            recursive(s + ")", i, j + 1, n, list);
        }
    }

    //爬楼梯
    static class Solution7 {

        public int climbStairs(int n) {
            if (n == 1 || n == 2) {
                return n;
            }
            int[] cache = new int[n + 1];
            cache[1] = 1;
            cache[2] = 2;
            return recursive(n, cache);
        }

        public int recursive(int n, int[] cache) {
            if (n == 1 || n == 2) {
                return cache[n];
            }
            if (cache[n] == 0) {
                int n1 = recursive(n - 1, cache);
                int n2 = recursive(n - 2, cache);
                cache[n] = n1 + n2;
            }
            return cache[n];
        }


    }


    public static void main(String[] args) {
        //        char[] s = new char[]{'h', 'e', 'l', 'l', 'o'};
        System.out.println(new Solution7().climbStairs(3));
    }


}






























