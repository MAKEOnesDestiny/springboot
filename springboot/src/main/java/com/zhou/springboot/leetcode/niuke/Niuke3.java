package com.zhou.springboot.leetcode.niuke;

public class Niuke3 {


    public static class ListNode {

        int val;
        ListNode next = null;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // write code here
        if (l1 == null || l2 == null) {
            return l1 == null ? l2 : l1;
        }
        ListNode res = null;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                if (res == null) {
                    res = l1;
                } else {
                    res.next = l1;
                    res = l1;
                }
                l1 = l1.next;
            } else {
                if (res == null) {
                    res = l2;
                } else {
                    res.next = l2;
                    res = l2;
                }
                l2 = l2.next;
            }
        }
        if (l1 != null) {
            res.next = l1;
        }
        if (l2 != null) {
            res.next = l2;
        }
        return res;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(5);
        ListNode l2 = new ListNode(1);
        ListNode l22 = new ListNode(2);
        ListNode l23 = new ListNode(4);
        l2.next = l22;
        l22.next = l23;

        new Niuke3().mergeTwoLists(l1,l2);
    }

}
