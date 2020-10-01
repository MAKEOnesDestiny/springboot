package com.zhou.springboot.leetcode.l2009;


//07.重建二叉树
//输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
public class Offer07 {

    static class Solution {

        public TreeNode buildTree(int[] preorder, int[] inorder) {
            return recursive(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
        }

        public TreeNode recursive(int[] preorder, int[] inorder, int p1, int p2, int i1, int i2) {
            if (p1 > p2 || i1 > i2) {
                return null;
            }
            TreeNode t = new TreeNode(preorder[p1]);
            int bound = i1;
            for (int i = i1; i <= i2; i++) {
                if (preorder[p1] == inorder[i]) {
                    bound = i;
                    break;
                }
            }
            t.left = recursive(preorder, inorder, p1 + 1, bound - i1 + p1, i1, bound - 1);
            t.right = recursive(preorder, inorder, bound - i1 + p1 + 1, p2, bound + 1, i2);
            return t;
        }

    }

    static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        //        int[] pre = new int[]{3, 9, 20, 15, 7};
        int[] pre = new int[]{1, 2, 3};
        //        int[] in = new int[]{9, 3, 15, 20, 7};
        int[] in = new int[]{1, 3, 2};
        TreeNode root = new Solution().buildTree(pre, in);
        System.out.println();
    }

}
