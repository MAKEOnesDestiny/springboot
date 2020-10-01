package com.zhou.springboot.leetcode.l2009;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Offer32_2 {

    //从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行
    //给定二叉树: [3,9,20,null,null,15,7],
    //执行用时：
    //1 ms
    //, 在所有 Java 提交中击败了
    //93.28%
    //的用户
    //内存消耗：
    //39.2 MB
    //, 在所有 Java 提交中击败了
    //20.35%
    //的用户
    class Solution {

        private List<List<Integer>> res = new ArrayList<>();

        private TreeNode checkPoint = null;

        public List<List<Integer>> levelOrder(TreeNode root) {
            checkPoint = root;
            recursive(root, new ArrayList<>(), new LinkedList<>());
            return res;
        }

        public void recursive(TreeNode n, List<Integer> list, LinkedList<TreeNode> queue) {
            if (n == null) {
                return;
            }
            list.add(n.val);
            if (n == checkPoint) {
                res.add(list);
                list = new ArrayList<>();
                checkPoint = null;
            }
            if (n.left != null) {
                queue.add(n.left);
            }
            if (n.right != null) {
                queue.add(n.right);
            }
            checkPoint = checkPoint == null && queue.size() > 0 ? queue.getLast() : checkPoint;
            while (queue.size() > 0) {
                TreeNode p = queue.poll();
                recursive(p, list, queue);
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
