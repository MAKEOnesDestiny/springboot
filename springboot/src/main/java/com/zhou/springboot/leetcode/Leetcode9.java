package com.zhou.springboot.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

@SuppressWarnings("all")
public class Leetcode9 {

    public static class ListNode {

        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    static class Node {

        public int val;
        public Node left;
        public Node right;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }

    ;

    //错误解法
    static class Solution {

        public int maxProfit(int[] prices) {
            int min = prices[0];
            int max = prices[0];
            int p = 0;
            for (int i = 0; i < prices.length; i++) {
                if (prices[i] >= max) {
                    max = prices[i];
                    p = i;
                }
                if (min >= prices[i] && i < p) {
                    min = prices[i];
                }
            }
            return max - min;
        }
    }

    //假设把某股票的价格按照时间先后顺序存储在数组中，请问买卖该股票一次可能获得的最大利润是多少？
    static class Solution2 {

        public int maxProfit(int[] prices) {
            if (prices == null || prices.length <= 1) {
                return 0;
            }
            int max = 0;
            int min = prices[0];
            for (int i = 1; i < prices.length; i++) {
                if (prices[i] <= min) {
                    min = prices[i];
                } else {
                    max = Math.max(max, prices[i] - min);
                }
            }
            return max;
        }
    }


    //difficult!!!!!!
    //输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的循环双向链表。要求不能创建任何新的节点，只能调整树中节点指针的指向。
    //中序遍历
    static class Solution3 {

        public Node prev;
        public Node head;

        public Node treeToDoublyList(Node root) {
            if (root == null) {
                return null;
            }
            dfs(root);
            head.left = prev;
            prev.right = head;
            return head;
        }

        public void dfs(Node root) {
            if (root == null) {
                return;
            }
            dfs(root.left);
            if (prev == null) {
                head = root;
            } else if (prev != null) {
                prev.right = root;
            }
            root.left = prev;
            prev = root;
            dfs(root.right);
        }

    }

    //前序遍历
    static class Solution4 {

        public Node prev;

        public Node head;

        public Node treeToDoublyList(Node root) {
            dfs(root);
            return head;
        }

        public void dfs(Node root) {
            if (root == null) {
                return;
            }
            Node left = root.left;
            Node right = root.right;
            root.left = prev;
            if (prev == null) {
                head = root;
            }
            if (prev != null) {
                prev.right = root;
            }
            prev = root;
            dfs(left);
            dfs(right);
        }
    }

    //后序遍历
    static class Solution5 {

        public Node head;
        public Node prev;

        public Node treeToDoublyList(Node root) {
            dfs(root);
            return head;
        }

        public void dfs(Node root) {
            if (root == null) {
                return;
            }
            dfs(root.left);
            dfs(root.right);
            root.left = prev;
            if (prev == null) {
                head = root;
            }
            if (prev != null) {
                prev.right = root;
            }
            prev = root;
        }

    }


    //offer22.输入两个链表，找出它们的第一个公共节点。
    public static class Solution6 {

        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            if (headA == headB) {
                return headA;
            }
            ListNode a = headA;
            ListNode b = headB;
            while (a != null) {
                b = headB;
                while (b != null) {
                    if (b == a) {
                        //found
                        return a;
                    }
                    b = b.next;
                }
                a = a.next;
            }
            return null;
        }
    }


    //数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
    //    输入: [1, 2, 3, 2, 2, 2, 5, 4, 2]
    //    输出: 2
    //复杂度o(n)
    //diffiult
    public static class Solution7 {

        public int majorityElement(int[] nums) {
            int min = 0;
            int max = nums.length - 1;
            int mid = (min + max) / 2;
            int p = partition(nums, min, max);
            while (p != mid) {
                if (p > mid) {
                    max = p - 1;
                    p = partition(nums, min, max);
                } else if (p < mid) {
                    min = p + 1;
                    p = partition(nums, min, max);
                }
            }
            return nums[p];
        }

        public void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }

        public int partition(int[] nums, int min, int max) {
            int small = min;
            swap(nums, min, max);
            for (int i = min; i < max; i++) {
                if (nums[i] < nums[max]) {
                    swap(nums, i, small);
                    small++;
                }
            }
            swap(nums, small, max);
            return small;
        }
    }

    public static void main2(String[] args) {
        //        int[] nums = new int[]{1, 2, 3, 2, 2, 2, 5, 4, 2};
        int[] nums = new int[]{1, 2, 3, 2, 2, 2, 5, 4, 2, 3, 3, 3, 3};
        System.out.println(new Solution7().majorityElement(nums));
    }

    //剑指 Offer 37. 序列化二叉树
    //[1,2,3,null,null,4,5]
    //表示为[1,null,2,3] 而非[1,null,2,null,null,3]
    //超过时间限制！！
    //错误！！！
    //todo:error
    public static class CodecError {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            List<Integer> l = new ArrayList<>();
            recursive(root, l, 0);
            return l.toString();
        }

        public void recursive(TreeNode n, List<Integer> l, int index) {
            if (n == null) {
                return;
            }
            int i = l.size();
            while (i < index) {
                l.add(i++, null);
            }
            l.add(index, n.val);
            recursive(n.left, l, 2 * index + 1);
            recursive(n.right, l, 2 * index + 2);
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            String[] ss = data.replaceAll("\\[", "").replaceAll("\\]", "").split(",");
            TreeNode head = new TreeNode(Integer.valueOf(ss[0])); ;
            recursive2(head, ss, 0);
            return head;
        }

        public void recursive2(TreeNode n, String[] ss, int i) {
            if (n == null) {
                return;
            }
            if (2 * i + 1 < ss.length && !"null".equals(ss[2 * i + 1])) {
                n.left = new TreeNode(Integer.valueOf(ss[2 * i + 1]));
                recursive2(n.left, ss, 2 * i + 1);
            }
            if (2 * i + 2 < ss.length && !"null".equals(ss[2 * i + 2])) {
                n.right = new TreeNode(Integer.valueOf(ss[2 * i + 2]));
                recursive2(n.right, ss, 2 * i + 2);
            }
        }
    }

    public static class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            if (root == null) {
                return "null,";
            }
            String result = "";
            result += root.val + ",";
            result += serialize(root.left);
            result += serialize(root.right);
            return result;
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            String[] ss = data.split(",");
            Queue<String> q = new LinkedList();
            for (String s : ss) {
                q.offer(s);
            }
            return helpBuild(q);
        }

        public TreeNode helpBuild(Queue<String> q) {
            String s = q.poll();
            if ("null".equals(s)) {
                return null;
            }
            TreeNode root = new TreeNode(Integer.valueOf(s));
            root.left = helpBuild(q);
            root.right = helpBuild(q);
            return root;
        }

    }

    public static void main(String[] args) {

/*        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);

        n1.left = n2;
        n1.right = n3;
        n3.left = n4;
        n3.right = n5;*/
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);

        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n3.left = n5;
        n3.right = n6;

        System.out.println(new Codec().serialize(n1));

        //        TreeNode n = new Codec().deserialize("[1,2,3,null,null,4,5]");
//        TreeNode n = new Codec().deserialize("[1,2,3,4,null,5,6]");
        TreeNode n = new Codec().deserialize("1,2,4,null,null,null,3,5,null,null,6,null,null,");
        System.out.println();
    }

    public static void main1(String[] args) {
        //[4,2,5,1,3]
        Node n1 = new Node(4);
        Node n2 = new Node(2);
        Node n3 = new Node(5);
        Node n4 = new Node(1);
        Node n5 = new Node(3);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        Node n = new Solution5().treeToDoublyList(n1);
        System.out.println();
    }

}























