package com.zhou.springboot.leetcode;


public class Leetcode8 {

    public static class TreeNode {

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

    //二叉树中的最大路径和
    static class Solution {

        public int recursive(TreeNode root, int[] res) {
            if (root == null) {
                return 0;
            }
            int max = root.val;
            int left = Math.max(recursive(root.left, res), 0);
            int right = Math.max(recursive(root.right, res), 0);
            res[0] = Math.max(res[0], max + left + right);
            return max + Math.max(left, right);
        }

        public int maxPathSum(TreeNode root) {
            int[] res = new int[]{Integer.MIN_VALUE};
            recursive(root, res);
            return res[0];
        }

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(-2, new TreeNode(1), null);
        System.out.println(new Solution().maxPathSum(root));
    }

}
