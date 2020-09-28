package com.zhou.springboot.leetcode.l2009;

import java.util.ArrayList;
import java.util.List;

//执行用时：
//4 ms
//, 在所有 Java 提交中击败了
//9.53%
//的用户
//内存消耗：
//39.7 MB
//, 在所有 Java 提交中击败了
//6.62%
//的用户

@SuppressWarnings("all")
public class Offer34 {

    public static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) { val = x; }
    }

    //剑指 Offer 34. 二叉树中和为某一值的路径
    //输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。
    static class Solution {

        public List<List<Integer>> pathSum(TreeNode root, int sum) {
            if (root == null && sum == 1) {
                return new ArrayList<>();
            }
            List<List<Integer>> result = recursive(root, sum);
            if (result == null) {
                return new ArrayList<>();
            } else {
                return result;
            }
        }

        public List<List<Integer>> recursive(TreeNode root, int sum) {
            if (root == null && sum == 0) {
                return new ArrayList<>();
            } else if (root == null) {
                return null;
            }
            List<List<Integer>> list1 = recursive(root.left, sum - root.val);
            List<List<Integer>> list2 = recursive(root.right, sum - root.val);
            List<List<Integer>> list = new ArrayList<>();
            if (list1 != null && list2 != null && list1.size() == 0 && list2.size() == 0) {
                List<Integer> listInner = new ArrayList<Integer>();
                listInner.add(root.val);
                list.add(listInner);
            }
            if (list1 != null) {
                list1.forEach((t) -> {
                    List<Integer> listInner = new ArrayList<Integer>();
                    listInner.add(0, root.val);
                    listInner.addAll(t);
                    list.add(listInner);
                });

            }
            if (list2 != null) {
                list2.forEach((t) -> {
                    List<Integer> listInner = new ArrayList<Integer>();
                    listInner.add(0, root.val);
                    listInner.addAll(t);
                    list.add(listInner);
                });

            }
            return list.size() == 0 ? null : list;
        }

    }

    public static void main(String[] args) {
        //[5,4,8,11,null,13,4,7,2,null,null,5,1]
        TreeNode r = new TreeNode(5);
        TreeNode r1 = new TreeNode(4);
        TreeNode r2 = new TreeNode(8);
        TreeNode r11 = new TreeNode(11);
        TreeNode r21 = new TreeNode(13);
        TreeNode r22 = new TreeNode(4);
        TreeNode r111 = new TreeNode(7);
        TreeNode r112 = new TreeNode(2);
        TreeNode r221 = new TreeNode(5);
        TreeNode r222 = new TreeNode(1);

        r.left = r1;
        r.right = r2;
        r1.left = r11;
        r2.left = r21;
        r2.right = r22;
        r11.left = r111;
        r11.right = r112;
        r22.left = r221;
        r22.right = r222;
        System.out.println(new Solution().pathSum(r, 13));


    }

}
