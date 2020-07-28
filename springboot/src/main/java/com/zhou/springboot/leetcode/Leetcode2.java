package com.zhou.springboot.leetcode;

import java.util.*;

public class Leetcode2 {

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    //中序遍历二叉树
    class Solution1 {
        public class TreeNode {
            int val;
            TreeNode left;
            TreeNode right;

            TreeNode(int x) {
                val = x;
            }
        }

        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> result = new ArrayList<>();
            Stack<TreeNode> stack = new Stack<>();
            while (root != null || !stack.isEmpty()) {
                while (root != null) {
                    stack.push(root);
                    root = root.left;
                }
                root = stack.pop();
                result.add(root.val);
                root = root.right;
            }
            return result;
        }
    }

    //寻找重复数字？？？
    static class Solution2 {
        public int findDuplicate(int[] nums) {
            /**
             快慢指针思想, fast 和 slow 是指针, nums[slow] 表示取指针对应的元素
             注意 nums 数组中的数字都是在 1 到 n 之间的(在数组中进行游走不会越界),
             因为有重复数字的出现, 所以这个游走必然是成环的, 环的入口就是重复的元素,
             即按照寻找链表环入口的思路来做
             **/
            int fast = 0, slow = 0;
            while (true) {
                fast = nums[nums[fast]];
                slow = nums[slow];
                if (slow == fast) {
                    fast = 0;
                    while (nums[slow] != nums[fast]) {
                        fast = nums[fast];
                        slow = nums[slow];
                    }
                    return nums[slow];
                }
            }
        }
    }

    static class Solution3 {
        //g 小孩  s饼干
        public int findContentChildren(int[] g, int[] s) {
            Arrays.sort(g);
            Arrays.sort(s);
            int child = 0;
            for (int i = 0; i < s.length; i++) {
                if (g[child] <= s[i]) {
                    child++;
                }
                if (child >= g.length) {
                    break;
                }
            }
            return child;
        }
    }

    //滑窗
    static class Solution4 {
        public int lengthOfLongestSubstring(String s) {
            Map<Character, Integer> location = new HashMap<>();
            int i = 0, j = 0;
            int length = s.length();
            int result = 0;
            for (; j < length; j++) {
                Character c = s.charAt(j);
                if (location.containsKey(c)) {
                    i = Math.max(location.get(c) + 1, i);
                    location.put(c, j);
                } else {
                    location.put(c, j);
                }
                result = Math.max(result, j - i + 1);
            }
            return result;
        }
    }

    //归并排序
    class Solution5 {
        public class ListNode {
            int val;
            ListNode next;

            ListNode() {
            }

            ListNode(int val) {
                this.val = val;
            }

            ListNode(int val, ListNode next) {
                this.val = val;
                this.next = next;
            }
        }

        // 输入：1->2->4, 1->3->4
        //输出：1->1->2->3->4->4
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            ListNode dummy = new ListNode(0, null);
            ListNode tail = dummy;
            for (; ; ) {
                if (l1 != null && l2 != null) {
                    if (l1 != null && l1.val < l2.val) {
                        tail.next = l1;
                        tail = l1;
                        l1 = l1.next;
                    } else if (l2 != null && l1.val >= l2.val) {
                        tail.next = l2;
                        tail = l2;
                        l2 = l2.next;
                    }
                } else {
                    if (l1 != null) {
                        do {
                            tail.next = l1;
                            tail = l1;
                            l1 = l1.next;
                        } while (l1 != null);
                    }
                    if (l2 != null) {
                        do {
                            tail.next = l2;
                            tail = l2;
                            l2 = l2.next;
                        } while (l2 != null);
                    }
                    break;
                }
            }
            return dummy.next;
        }
    }

    //给定一个 没有重复 数字的序列，返回其所有可能的全排列。
    //
    // 示例:
    //
    // 输入: [1,2,3]
    //输出:
    //[
    //  [1,2,3],
    //  [1,3,2],
    //  [2,1,3],
    //  [2,3,1],
    //  [3,1,2],
    //  [3,2,1]
    //]
    class Solutiontest {
        public List<List<Integer>> permute(int[] nums) {

            List<List<Integer>> res = new ArrayList<>();
            int[] visited = new int[nums.length];
            backtrack(res, nums, new ArrayList<Integer>(), visited);
            return res;

        }

        private void backtrack(List<List<Integer>> res, int[] nums, ArrayList<Integer> tmp, int[] visited) {
            if (tmp.size() == nums.length) {
                res.add(new ArrayList<>(tmp));
                return;
            }
            for (int i = 0; i < nums.length; i++) {
                if (visited[i] == 1) continue;
                visited[i] = 1;
                tmp.add(nums[i]);
                backtrack(res, nums, tmp, visited);
                visited[i] = 0;
                tmp.remove(tmp.size() - 1);
            }
        }
    }


    static class Solution6 {

        public List<List<Integer>> permute(int[] nums) {
            int[] visited = new int[nums.length]; //0代表未使用，1代表已经使用
            List<List<Integer>> result = new ArrayList<>();
            back(result, new ArrayList<>(), nums);
            return result;
        }

        public void back(List<List<Integer>> result, List<Integer> hasGet, int[] nums) {
            if (hasGet.size() == nums.length) {
                result.add(new ArrayList<>(hasGet));
//                result.add(Arrays.asList(hasGet.toArray(new Integer[0])));
                return;
            }
            for (int i = 0; i < nums.length; i++) {
                if (hasGet.contains(nums[i])) {
                    continue;
                } else {
                    hasGet.add(nums[i]);
                }
                back(result, hasGet, nums);
                hasGet.remove(hasGet.indexOf(nums[i])); //撤销操作
            }
        }
    }

    static class Solution7test {
        public int largestRectangleArea(int[] heights) {
            // 这里为了代码简便，在柱体数组的头和尾加了两个高度为 0 的柱体。
            int[] tmp = new int[heights.length + 2];
            System.arraycopy(heights, 0, tmp, 1, heights.length);

            Deque<Integer> stack = new ArrayDeque<>();
            int area = 0;
            for (int i = 0; i < tmp.length; i++) {
                // 对栈中柱体来说，栈中的下一个柱体就是其「左边第一个小于自身的柱体」；
                // 若当前柱体 i 的高度小于栈顶柱体的高度，说明 i 是栈顶柱体的「右边第一个小于栈顶柱体的柱体」。
                // 因此以栈顶柱体为高的矩形的左右宽度边界就确定了，可以计算面积～
                while (!stack.isEmpty() && tmp[i] < tmp[stack.peek()]) {
                    int h = tmp[stack.pop()];
                    area = Math.max(area, (i - stack.peek() - 1) * h);
                }
                stack.push(i);
            }

            return area;
        }
    }

    static class Solution {
        public int trap(int[] height) {
            if (height == null) {
                return 0;
            }
            Stack<Integer> stack = new Stack<>();
            int ans = 0;
            for (int i = 0; i < height.length; i++) {
                while(!stack.isEmpty() && height[stack.peek()] < height[i]) {
                    int curIdx = stack.pop();
                    while (!stack.isEmpty() && height[stack.peek()] == height[curIdx]) {
                        stack.pop();
                    }
                    if (!stack.isEmpty()) {
                        int stackTop = stack.peek();
                        ans += (Math.min(height[stackTop], height[i]) - height[curIdx]) * (i - stackTop - 1);
                    }
                }
                stack.add(i);
            }
            return ans;
        }
    }


    public static void main(String[] args) {
//        System.out.println(new Solution10().permute(new int[]{1, 2, 3}));
        int[] nums = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        new Solution().trap(nums);

    }

}







































