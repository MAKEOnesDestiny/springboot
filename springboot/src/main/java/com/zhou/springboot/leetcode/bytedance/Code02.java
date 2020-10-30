package com.zhou.springboot.leetcode.bytedance;

public class Code02 {


    public static class ListNode {

        int val;
        ListNode next;

        ListNode() {}

        ListNode(int val) { this.val = val; }

        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    //给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
    //
    //如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
    //
    //您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
    static class Solution {

        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            int more = 0;
            ListNode root = new ListNode();
            ListNode n = root;
            while (l1 != null && l2 != null) {
                int r = (l1.val + l2.val) + more;
                more = r / 10;
                ListNode next = new ListNode(r % 10);
                n.next = next;
                n = next;
                l1 = l1.next;
                l2 = l2.next;
            }
            while (l1 != null) {
                int r = l1.val + more;
                more = r / 10;
                n.next = new ListNode(r % 10);
                n = n.next;
                l1 = l1.next;
            }
            while (l2 != null) {
                int r = l2.val + more;
                more = r / 10;
                n.next = new ListNode(r % 10);
                n = n.next;
                l2 = l2.next;
            }
            if(more>0){
                n.next = new ListNode(more);
            }
            return root.next;
        }
    }

}
