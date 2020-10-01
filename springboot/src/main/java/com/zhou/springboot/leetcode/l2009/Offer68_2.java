package com.zhou.springboot.leetcode.l2009;

public class Offer68_2 {

    //给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
    class Solution {

        //执行用时：
        //10 ms
        //, 在所有 Java 提交中击败了
        //18.38%
        //的用户
        //内存消耗：
        //41.2 MB
        //, 在所有 Java 提交中击败了
        //9.00%
        //的用户
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if (root == null) {
                return null;
            }
            if (root == p) {
                return p;
            }
            if (root == q) {
                return q;
            }
            TreeNode l = lowestCommonAncestor(root.left, p, q);
            TreeNode r = lowestCommonAncestor(root.right, p, q);
            if (l != null && r != null) {
                return root;
            } else {
                return l == null ? r : l;
            }
        }

    }

    public static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) { val = x; }
    }

}
