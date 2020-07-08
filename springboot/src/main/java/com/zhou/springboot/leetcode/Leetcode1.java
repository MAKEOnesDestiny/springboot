package com.zhou.springboot.leetcode;

import java.util.Arrays;
import java.util.Stack;

public class Leetcode1 {

    //leetcode submit region begin(Prohibit modification and deletion)
    static class MinStack {

        class Node {
            int value;
            Node prev;

            public Node(int value, Node prev) {
                this.value = value;
                this.prev = prev;
            }
        }

        protected Stack<Node> sn = new Stack<>();

        /**
         * initialize your data structure here.
         */
        public MinStack() {
        }

        public void push(int x) {
            Node prev = sn.size() == 0 ? null : sn.peek();
            sn.push(new Node(x, prev));
        }

        public void pop() {
            sn.pop();
        }

        public int top() {
            return sn.peek().value;
        }

        public int getMin() {
            Node top = sn.peek();
            int result = top.value;
            Node pp = top;
            while ((pp = pp.prev) != null) {
                result = Math.min(result, pp.value);
            }
            return result;
        }
    }

    //
    class Solution1 {
        public int[] subSort(int[] array) {
            //[1,2,4,7,10,11,7,12,6,7,16,18,19]
            int[] copy = array.clone();
            Arrays.sort(copy);
            int left = -1;
            int right = -1;
            for (int i = 0; i < copy.length; i++) {
                if (copy[i] != array[i]) {
                    if (left == -1) {
                        left = i;
                    }
                    right = i;
                }
            }
            return new int[]{left, right};
        }
    }

    //斐切那波数列
    static class Solution2 {
        public int fib(int n) {
            //f(0)=0 f(1)=1
            if (n == 0) return 0;
            if (n == 1) return 1;

            int before = 0;
            int beforenext = 1;
            int result = 0;
            for (int i = n; i >= 2; i--) {
                result = before + beforenext;
                result = result % 1000000007;
                before = beforenext;
                beforenext = result;
            }
            return result;
        }
    }

    //三角形最小路径-动态规
//
// [
//     [2],
//    [3,4],
//   [6,5,7],
//  [4,1,8,3]
//]
//
//int[] inta[] = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
    static class Solution3 {
        public int minPathSum(int[][] grid) {
            int n = grid.length; //行数
            int[] t = new int[n];
            for (int i = 0; i < n; i++) {
                t[i] = grid[n - 1][i];
            }
            int i = grid.length - 1;
            for (; i < n && i > 0; i--) { //i代表行
                int j = 0;
                for (; j < i; j++) { //j代表列
                    int a = grid[i - 1][j] + t[j];
                    int b = grid[i - 1][j] + t[j + 1];
                    t[j] = Math.min(a, b);
                }
            }
            return t[0];
        }
    }

    //硬币问题
    //硬币。给定数量不限的硬币，币值为25分、10分、5分和1分，编写代码计算n分有几种表示法。(结果可能会很大，你需要将结果模上1000000007)
    static class Solution4 {

        private final int mod = 1000000007;
        private final int[] coins = {25, 10, 5, 1};

        public int waysToChange(int n) {
            int res[] = new int[n + 1];
            res[0] = 1;
            for (int i = 0; i < coins.length; i++) {
                int coin = coins[i];
                for (int j = coin; j <= n; j++) {
                    res[j] = (res[j] + res[j - coin]) % mod;
                }
            }
            return res[n];
        }
    }


    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    //链表插入排序
    static class Solution {

        public static class ListNode {
            int val;
            ListNode next;

            ListNode(int x) {
                val = x;
            }
        }

        public static ListNode dummy = new ListNode(0);

        public static ListNode insertionSortList(ListNode head) {
            ListNode dummy = Solution.dummy;
            dummy.next = head;
            ListNode pos = dummy;
            while (head != null && head.next != null) {
                if(head.val<=head.next.val){
                    head = head.next;
                    continue;
                }
                while (head.next.val > pos.next.val) {
                    pos = pos.next;
                }
                ListNode tmp = head.next.next;
                head.next.next = pos.next;
                pos.next = head.next;
                head.next = tmp;
                pos = dummy;
            }
            return dummy.next;
        }
    }

    class Solution7 {
        public class ListNode {
            int val;
            ListNode next;

            ListNode(int x) {
                val = x;
            }
        }

        public ListNode insertionSortList(ListNode head) {
            ListNode dummy = new ListNode(0), pre;
            dummy.next = head;

            while (head != null && head.next != null) {
                if (head.val <= head.next.val) {
                    head = head.next;
                    continue;
                }
                pre = dummy;

                while (pre.next.val < head.next.val) pre = pre.next;

                ListNode curr = head.next;
                head.next = curr.next;
                curr.next = pre.next;
                pre.next = curr;
            }
            return dummy.next;
        }
    }

    public static void main(String[] args) {
        Solution.ListNode root = new Solution.ListNode(4);
        root.next = new Solution.ListNode(2);
        root.next.next = new Solution.ListNode(3);
        root.next.next.next = new Solution.ListNode(1);
        Solution.ListNode result = Solution.insertionSortList(root);
        System.out.println();
    }


}
