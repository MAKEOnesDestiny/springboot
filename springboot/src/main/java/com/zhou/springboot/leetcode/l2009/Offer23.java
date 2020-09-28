package com.zhou.springboot.leetcode.l2009;

//面试题 02.08. 环路检测
//给定一个链表，如果它是有环链表，实现一个算法返回环路的开头节点。
public class Offer23 {

    static class ListNode {

        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public class Solution {

        public ListNode detectCycle(ListNode head) {
            ListNode quick = head;
            ListNode slow = head;
            while (quick != null) {
                quick = quick.next != null ? quick.next.next : null;
                slow = slow.next;
                if (quick == slow) {
                    break;
                }
            }
            //无环
            if (quick == null) {
                return null;
            }
            //有环，找环
            slow = head;
            while(slow != quick){
                slow = slow.next;
                quick = quick.next;
            }
            return quick;
        }
    }

}
