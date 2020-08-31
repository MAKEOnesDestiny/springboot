package com.zhou.springboot.leetcode;


import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

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

    public static class ListNode {

        int val;
        ListNode next;

        ListNode(int x) { val = x; }
    }

    //二叉树中的最大路径和
    static class Solution1 {

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

    /**
     * Definition for singly-linked list. public class ListNode { int val; ListNode next; ListNode(int x) { val = x; }
     * }
     */
    //在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。
    //复杂度要求nlogn
    //归并排序版本
    static class Solution2 {

        public ListNode sortList(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode slowp = head;
            ListNode quickq = head;
            while (quickq.next != null && quickq.next.next != null) {
                slowp = slowp.next;
                quickq = quickq.next.next;
            }
            ListNode temp = slowp.next;
            slowp.next = null;
            return merge(sortList(head), sortList(temp));
        }

        public ListNode merge(ListNode l, ListNode r) {
            ListNode head = null;
            ListNode temp = null;
            while (l != null && r != null) {
                if (head == null) {
                    if (l.val <= r.val) {
                        head = l;
                        l = l.next;
                    } else {
                        head = r;
                        r = r.next;
                    }
                    temp = head;
                } else {
                    if (l.val <= r.val) {
                        head.next = l;
                        l = l.next;
                    } else {
                        head.next = r;
                        r = r.next;
                    }
                    head = head.next;
                }
            }
            if (l != null) {
                head.next = l;
            }
            if (r != null) {
                head.next = r;
            }
            return temp;
        }

    }

    //快速排序版本
    class Solution {

        public ListNode sortList(ListNode head) {
            ListNode n = head;
            ListNode p = head;
            ListNode t = n;
            while ((n = n.next) != null) {
                if (n.val > p.val) {
                    t.next = n;

                }
            }
            return null;
        }

    }


    public static void main(String[] args) throws InterruptedException {
        Lock l = new ReentrantLock();
        l.newCondition().await();

        ListNode node1 = new ListNode(4);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(1);
        ListNode node4 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        ListNode head = new Solution2().sortList(node1);
        System.out.println();
    }

}
