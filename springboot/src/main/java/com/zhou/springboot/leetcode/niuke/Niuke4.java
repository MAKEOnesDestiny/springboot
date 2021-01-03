package com.zhou.springboot.leetcode.niuke;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class Niuke4 {

    public static class TreeNode {

        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
    }

    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList();
        }
        // write code here
        ArrayList<ArrayList<Integer>> res = new ArrayList();
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root); //初始化
        int level = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            ArrayList<Integer> t = new ArrayList();
            for (int i = 0; i < size; i++) {
                //同一层的统一处理掉
                TreeNode n = queue.poll();
                if (level % 2 != 0) {
                    //奇数层
                    t.add(Integer.valueOf(n.val));
                } else {
                    t.add(0, Integer.valueOf(n.val));
                }
                if (n.left != null) {
                    queue.addLast(n.left);
                }
                if (n.right != null) {
                    queue.addLast(n.right);
                }
            }
            res.add(t);
            level++;
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode();
        root.val = 1;

        TreeNode l = new TreeNode();
        l.val = 2;
        TreeNode r = new TreeNode();
        r.val = 3;

        root.left = l;
        root.right = r;

        System.out.println(new Niuke4().zigzagLevelOrder(root));
    }

}
