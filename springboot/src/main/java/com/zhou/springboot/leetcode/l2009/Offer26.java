package com.zhou.springboot.leetcode.l2009;


import java.util.LinkedList;
import java.util.Queue;

public class Offer26 {

    //剑指 Offer 26. 树的子结构
    static class Solution {

        public boolean isSubStructure(TreeNode A, TreeNode B) {
            if (B == null) {
                return false;
            }
            Queue<TreeNode> queue = new LinkedList<>();
            recursive(A, B,queue);
            while (queue.size()>0) {
                if(isSame(queue.poll(),B)){
                    return true;
                }
            }
            return false;
        }

        public boolean isSame(TreeNode a, TreeNode b) {
            if (a == null || b == null) {
                return a == b;
            }
            if (a.val != b.val) {
                return false;
  /*              TreeNode f = recursive(a, B);
                if (f == null) {
                    return false;
                }
                if (f != null) {
                    a = f;
                    b = B;
                }*/
            }
            return isSame(a.left, b.left) && isSame(a.right, b.right);
        }

        public void recursive(TreeNode n, TreeNode toFound, Queue<TreeNode> queue) {
            if (n == null) {
                return ;
            }
            if (n.val == toFound.val) {
                queue.offer(n);
            }
            recursive(n.left, toFound, queue);
            recursive(n.right, toFound,queue);
        }
    }

    public static void main(String[] args) {
        TreeNode a = new TreeNode(4);
        TreeNode a1 = new TreeNode(2);
        TreeNode a2 = new TreeNode(3);
        TreeNode a21 = new TreeNode(4);
        TreeNode a22 = new TreeNode(5);
        TreeNode a31 = new TreeNode(8);
        TreeNode a32 = new TreeNode(9);
        a.left = a1;
        a.right = a2;
        a1.left = a21;
        a1.right = a22;
        a21.left = a31;
        a21.right = a32;

        TreeNode b = new TreeNode(4);
        TreeNode b1 = new TreeNode(8);
        TreeNode b2 = new TreeNode(9);
        b.left = b1;
        b.right = b2;

        System.out.println(new Solution().isSubStructure(a, b));
    }


    static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


}
