package com.zhou.springboot.leetcode.l2009;

public class Offer68_1 {

    //给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
    //执行用时：
    //9 ms
    //, 在所有 Java 提交中击败了
    //6.20%
    //的用户
    //内存消耗：
    //40.3 MB
    //, 在所有 Java 提交中击败了
    //25.59%
    //的用户
    class Solution {

        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if(p==root || q==root){
                return root;
            }
            if (p.val > root.val && q.val > root.val) {
                return lowestCommonAncestor(root.right, p, q);
            }else if(p.val <root.val && q.val < root.val){
                return lowestCommonAncestor(root.left, p, q);
            }else{
                return root;
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
