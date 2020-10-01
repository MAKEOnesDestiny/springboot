package com.zhou.springboot.leetcode.l2009;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Offer32_1 {

    public static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) { val = x; }
    }

    //从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
    //给定二叉树: [3,9,20,null,null,15,7],
    //执行用时：
    //2 ms
    //, 在所有 Java 提交中击败了
    //26.71%
    //的用户
    //内存消耗：
    //38.9 MB
    //, 在所有 Java 提交中击败了
    //53.28%
    //的用户
    static class Solution {

        public int[] levelOrder(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            recursive(root, res, new LinkedList<>());
            int[] resUnpack = new int[res.size()];
            int[] i = new int[]{0};
            res.stream().forEach(t -> resUnpack[i[0]++] = t);
            return resUnpack;
        }

        public void recursive(TreeNode n, List<Integer> res, Queue<TreeNode> queue) {
            if (n == null) {
                return;
            }
            res.add(n.val);
            if (n.left != null) {
                queue.offer(n.left);
            }
            if (n.right != null) {
                queue.offer(n.right);
            }
            while (queue.size() > 0) {
                recursive(queue.poll(), res, queue);
            }
        }
    }

}
