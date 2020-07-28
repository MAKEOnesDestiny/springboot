package com.zhou.springboot.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class Leetcode6 {

    //数组中第K个最大的元素  堆排序
    static class Solution1 {

        public int findKthLargest(int[] nums, int k) {
            for (int i = nums.length / 2 - 1; i >= 0; i--) {
                precDown(nums, i, nums.length);
            }
            for (int i = nums.length - 1; i > 0; i--) {
                swap(nums, 0, i);
                precDown(nums, 0, i);
            }
            return nums[k - 1];
        }

        public int leftChild(int i) {
            return 2 * i + 1;
        }

        public void precDown(int[] nums, int i, int n) {
            int temp = nums[i];
            int child;
            for (; leftChild(i) < n; i = child) {
                child = leftChild(i);
                if (child != n - 1 && nums[child] > nums[child + 1]) { //max or min heap
                    child++;
                }
                if (temp > nums[child]) {  //max or min heap
                    nums[i] = nums[child];
                } else {
                    break;
                }
            }
            nums[i] = temp;
        }

        public void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }

    }

    //第K个排列（比较慢）
    static class Solution11 {

        public String getPermutation(int n, int k) {
            int[] used = new int[n + 1]; //0:unused 1:used
            return recursiveGet(n, k, used);
        }

        //k代表排名剩余，n代表剩余字符个数
        public String recursiveGet(int n, int k, int[] used) {
            if (getN(n) < k) {
                return null;
            } else {
                int step = getN(n - 1);
                for (int i = 1; i < used.length; i++) {
                    if (used[i] == 1) {
                        //used
                        continue;
                    } else {
                        used[i] = 1;
                        if (k == 1) {
                            return getStrN(i, used);
                        }
                        String result = recursiveGet(--n, k, used);
                        used[i] = 0; //归还used
                        if (result != null) {
                            return i + result;
                        }
                        k -= 1 * step;
                        n++;
                    }
                }
                return null;
            }
        }

        public String getStrN(int i, int[] used) {
            String result = i + "";
            for (int j = 1; j < used.length; j++) {
                if (used[j] == 0) {
                    result += j;
                }
            }
            return result;
        }

        public int getN(int n) {
            int result = 1;
            for (int i = 1; i <= n; i++) {
                result *= i;
            }
            return result;
        }
    }

    /**
     * Definition for singly-linked list. public class ListNode { int val; ListNode next; ListNode(int x) { val = x; }
     * }
     */
    //翻转链表
    class Solution2 {

        public class ListNode {

            int val;
            ListNode next;

            ListNode(int x) { val = x; }
        }

        public ListNode reverseList(ListNode head) {
            if (head == null) {
                return null;
            }
            ListNode before = null;
            before = head;
            head = head.next;
            before.next = null;
            while (head != null) {
                ListNode temp = head.next;
                head.next = before;
                before = head;
                head = temp;
            }
            return before;
        }
    }


    /**
     * 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3 输出: [3,3,5,5,6,7]
     */
    //滑动窗口的最大值
    class Solution3 {

        public int[] maxSlidingWindow(int[] nums, int k) {
            if (nums.length <= 0) {
                return new int[]{};
            }
            int i = 0, j = 0;
            Deque<Integer> deque = new ArrayDeque();
            int[] res = new int[nums.length - k + 1];
            while (i < nums.length) {
                if (!deque.isEmpty() && i - deque.peek() >= k) {
                    deque.poll(); //左边走一个
                }
                while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                    deque.pollLast();
                }
                deque.offer(i);
                if (i + 1 >= k) {
                    res[j++] = nums[deque.peek()];
                }
                i++;
            }
            return res;
        }
    }

    //翻转二叉树
    class Solution4 {

        public class TreeNode {

            int val;
            TreeNode left;
            TreeNode right;

            TreeNode(int x) { val = x; }
        }

        public TreeNode invertTree(TreeNode root) {
            swap(root);
            return root;
        }

        //空间复杂度较高
        public void swap(TreeNode n) {
            if (n == null) {
                return;
            }
            TreeNode temp = n.left;
            n.left = n.right;
            n.right = temp;
            swap(n.left);
            swap(n.right);
        }

    }

    static class Solution5 {

        public int minArray(int[] numbers) {
            int before = numbers[0];
            for (int n : numbers) {
                if (n >= before) {
                    before = n;
                } else {
                    return n;
                }
            }
            return numbers[0];
        }
    }

    //机器人的运动范围
    static class Solution {

        public int movingCount(int m, int n, int k) {
            int[][] used = new int[m][n];
            return dfs(0, 0, m, n, k, used);
        }

        public int dfs(int i, int j, int m, int n, int k, int[][] used) {
            if ((i / 10 + i % 10 + j / 10 + j % 10 > k) || (i >= m || i < 0) || (j >= n || j < 0) || used[i][j] == 1) {
                return 0;
            }
            used[i][j] = 1;
            return dfs(i + 1, j, m, n, k, used) + dfs(i - 1, j, m, n, k, used) + dfs(i, j + 1, m, n, k, used) + dfs(i, j
                    - 1, m, n, k, used) + 1;
        }

    }


    public static void main(String[] args) throws InterruptedException {
        //        int[] nums = new int[]{2, 2, 2, 0, 1};

        System.out.println(new Solution().movingCount(1,2,1));
    }

}




