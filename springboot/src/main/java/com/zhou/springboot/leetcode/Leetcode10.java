package com.zhou.springboot.leetcode;

@SuppressWarnings("all  ")
public class Leetcode10 {

    /**
     * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode right; TreeNode(int
     * x) { val = x; } }
     */

    public class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) { val = x; }
    }

    //    输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
    //    输出: 6
    //    解释: 节点 2 和节点 8 的最近公共祖先是 6。
    class Solution1 {

        /**
         * difficult
         *
         * @param root
         * @param p
         * @param q
         */
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if (root == null || root.val == p.val || root.val == q.val) {
                return root;
            }
            TreeNode leftFound = lowestCommonAncestor(root.left, p, q);
            TreeNode rightFound = lowestCommonAncestor(root.right, p, q);
            if (leftFound != null && rightFound != null) {
                return root;
            } else {
                return leftFound != null ? leftFound : rightFound;
            }
        }

    }

    //difficult!!!!
    //1~n中1出现的数字
    static class Solution2 {

        public int countDigitOne(int n) {
            long count = 0;
            long pow = 1;
            while (n / pow > 0) {
                long cur = n / pow % 10;
                long high = n / (10 * pow);
                long low = n - (n / pow) * pow;
                if (cur == 0) {
                    count += high * pow;
                } else if (cur == 1) {
                    count = count + high * pow + low + 1;
                } else {
                    count = count + (high + 1) * pow;
                }
                pow = 10 * pow;
            }
            return (int) count;
        }
    }

    //数组中重复的数字
    //    输入：
    //            [2, 3, 1, 0, 2, 5, 3]
    //    输出：2 或 3
    static class Solution3 {

        public int findRepeatNumber(int[] nums) {
            recursive(nums, 0, nums.length - 1);
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == nums[i + 1]) {
                    return nums[i];
                }
            }
            return 0;
        }

        public void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }

        public int partition(int[] nums, int begin, int end) {
            int mid = begin;
            swap(nums, begin, end);
            for (int i = begin; i < end; i++) {
                if (nums[i] < nums[end]) {
                    swap(nums, mid, i);
                    mid++;
                }
            }
            swap(nums, mid, end);
            return mid;
        }

        public void recursive(int[] nums, int begin, int end) {
            int i = partition(nums, begin, end);
            if (begin < i) {
                recursive(nums, begin, i - 1);
            }
            if (i < end) {
                recursive(nums, i + 1, end);
            }
        }

    }


    //输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
    public static class Solution4Error {

        public int[] getLeastNumbers(int[] arr, int k) {
            int kk = k;
            for (; k > 0; k = k / 2) {
                for (int i = 0; i < k; i++) {
                    for (int j = i; j < arr.length; j += k) {
                        if (arr[j] < arr[i]) {
                            int temp = arr[i];
                            arr[i] = arr[j];
                            arr[j] = temp;
                        }
                    }
                }
            }
            int[] res = new int[kk];
            System.arraycopy(arr, 0, res, 0, kk);
            return res;
        }
    }

    //最小的K个数，快速排序版本
    //会修改数组
    public static class Solution4 {

        public int[] getLeastNumbers(int[] arr, int k) {
            int i = 0;
            int j = arr.length - 1;
            int p;
            while ((p = partition(arr, i, j)) != k) {
                if (p > k) {
                    j--;
                }
                if (p < k) {
                    i++;
                }
            }
            int res[] = new int[k];
            System.arraycopy(arr, 0, res, 0, k);
            return res;
        }

        public int partition(int[] arr, int i, int j) {
            int small = i;
            //交换第一个和最后一个
            swap(arr, small, j);
            for (int k = i; k < j; k++) {
                if (arr[k] < arr[j]) {
                    swap(arr, small++, k);
                }
            }
            swap(arr, small, j);
            return small;
        }

        public void swap(int[] arr, int m, int n) {
            int temp = arr[m];
            arr[m] = arr[n];
            arr[n] = temp;
        }

    }

    //输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。
    //耗时太长！！！花了1个小时做
    static class Solution5 {

        public boolean verifyPostorder(int[] postorder) {
            return recursive(postorder, 0, postorder.length - 1);
        }

        public boolean recursive(int[] postorder, int m, int n) {
            if (m >= n) {
                return true;
            }
            int index = m;
            while (index < n) {
                if (postorder[index] < postorder[n] && index + 1 < n) {
                    index++;
                } else {
                    break;
                }
            }
            int mid = index;
            while (index < n) {
                if (postorder[++index] < postorder[n]) {
                    return false;
                }
            }
            return recursive(postorder, m, mid) && recursive(postorder, m == mid ? mid : mid + 1, n - 1);
        }

    }


    //请完成一个函数，输入一个二叉树，该函数输出它的镜像。
    class Solution6 {

        public TreeNode mirrorTree(TreeNode root) {
            recursive(root);
            return root;
        }

        public void recursive(TreeNode root) {
            if (root == null) {
                return;
            }
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
            recursive(root.left);
            recursive(root.right);
        }
    }


    //二叉树层次遍历
    class Solution {

        public int[] levelOrder(TreeNode root) {
            int[] res = new int[1000];
            recursive(root, 0, res);
            return res;
        }

        public void recursive(TreeNode node, int i, int[] res) {
            if (node == null) {
                return;
            }
            res[i] = node.val;
            recursive(node.left, 2 * i + 1, res);
            recursive(node.right, 2 * i + 2, res);
        }
    }


    public static void main(String[] args) {
        //        int[] a = new int[]{1, 2, 5, 10, 6, 9, 4, 3};
        //        int[] a = new int[]{4,6,7,5};
        //        int[] a = new int[]{1, 2, 5, 10, 6, 9, 4, 3};
        int[] a = new int[]{7, 4, 6, 5};
        //        int[] a = new int[]{4, 8, 6, 12, 16, 14, 10};

        System.out.println(new Solution5().verifyPostorder(a));

/*        int[] origin = new int[]{4, 5, 1, 6, 2, 7, 3};
        int[] res = new Solution4().getLeastNumbers(origin, 4);
        Arrays.stream(res).forEach((t) -> {
            System.out.println(t);
        });

        //        System.out.println(new Solution2().countDigitOne(12));
        //        int[] a = new int[]{2, 3, 1, 0, 2, 5, 3};
        int[] a = new int[]{3, 1, 2, 3};
        new Solution3().findRepeatNumber(a);
        System.out.println();*/
    }

}
