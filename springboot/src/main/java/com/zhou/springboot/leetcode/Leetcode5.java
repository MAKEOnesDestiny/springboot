package com.zhou.springboot.leetcode;

import java.util.HashMap;
import java.util.Stack;

@SuppressWarnings("all")
public class Leetcode5 {

    //数值的整数次方
    //时间复杂度：O(logn)
    //空间复杂度：
    static class Solution1 {

        public double myPow(double x, int n) {
            if (n == 0) {
                return 1;
            }
            if (n == 1) {
                return x;
            }
            if (n == -1) {
                return 1d / x;
            }
            double x1 = myPow(x, n / 2);
            double x2 = myPow(x, n % 2);
            return x1 * x1 * x2;
        }

    }

    static class Solution2 {

        //时间复杂度：O(n)
        //空间复杂度：O(1)
        public int[] divingBoard(int shorter, int longer, int k) {
            if (k == 0) {
                return new int[0];
            }
            if (shorter == longer) {
                return new int[]{shorter * k};
            }
            int[] rlt = new int[k + 1];
            for (int i = 0; i < k + 1; i++) {
                rlt[i] = i * longer + (k - i) * shorter;
            }
            return rlt;
        }
    }

    static class Solution3 {
        public int maximalSquare(char[][] matrix) {
            /**
             dp[i][j]表示以第i行第j列为右下角所能构成的最大正方形边长, 则递推式为:
             dp[i][j] = 1 + min(dp[i-1][j-1], dp[i-1][j], dp[i][j-1]);
             **/
            int m = matrix.length;
            if (m < 1) return 0;
            int n = matrix[0].length;
            int max = 0;
            int[][] dp = new int[m + 1][n + 1];

            for (int i = 1; i <= m; ++i) {
                for (int j = 1; j <= n; ++j) {
                    if (matrix[i - 1][j - 1] == '1') {
                        dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1]));
                        max = Math.max(max, dp[i][j]);
                    }
                }
            }

            return max * max;
        }
    }


    static class Solution33 {
        //时间复杂度O(n)
        //空间复杂度O(n)
        public int maximalSquare(char[][] matrix) {
            int m = matrix.length;
            if (m < 1) return 0;
            int n = matrix[0].length;
            int result = 0;
            int[][] dp = new int[m + 1][n + 1];
            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    if (matrix[i - 1][j - 1] == '1') {
                        dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1]));
                        result = Math.max(result, dp[i][j]);
                    }
                }
            }
            return result * result;
        }
    }


    class Solution44 {
        public boolean exist(char[][] board, String word) {
            if (board == null || board[0] == null || board.length == 0 || board[0].length == 0 || word == null || word.equals("")) {
                return false;
            }
            boolean[][] isVisited = new boolean[board.length][board[0].length];
            char[] chs = word.toCharArray();

            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    if (board[i][j] == chs[0]) {
                        if (dfs(board, i, j, isVisited, chs, 0)) return true;
                    }
                }
            }
            return false;
        }

        private boolean dfs(char[][] board, int i, int j, boolean[][] isVisited, char[] chs, int index) {

            if (index == chs.length) {
                return true;
            }
            if (i < 0 || j < 0 || i == board.length || j == board[0].length || isVisited[i][j] || board[i][j] != chs[index]) {
                return false;
            }
            isVisited[i][j] = true;
            boolean res = dfs(board, i + 1, j, isVisited, chs, index + 1)
                    || dfs(board, i - 1, j, isVisited, chs, index + 1)
                    || dfs(board, i, j + 1, isVisited, chs, index + 1)
                    || dfs(board, i, j - 1, isVisited, chs, index + 1);
            isVisited[i][j] = false;
            return res;
        }
    }

    //矩阵中的路径
    static class Solution4 {

        public boolean exist(char[][] board, String word) {
            if (word == null || word.length() == 0 || board == null || board.length == 0 || board[0].length == 0) {
                return false;
            }
            char[] words = word.toCharArray();
            Stack<Character> stack = new Stack<>();
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    if (board[i][j] == words[0] && search(board, stack, 0, words, i, j)) {
                        return true;
                    }
                }
            }
            return false;
        }

        public boolean search(char[][] board, Stack<Character> stack, int index, char[] words, int i, int j) {
            stack.push(board[i][j]); //将ij入栈 并从board中剔除
            board[i][j] = '1';
            index++;
            if (words.length == stack.size()) {
                return true;
            }

            if (i > 0 && board[i - 1][j] == words[index] && search(board, stack, index, words, i - 1, j)) {//上
                return true;
            } else if (j < board[0].length - 1 && board[i][j + 1] == words[index] && search(board, stack, index, words, i, j + 1)) { //右
                return true;
            } else if (i < board.length - 1 && board[i + 1][j] == words[index] && search(board, stack, index, words, i + 1, j)) { //下
                return true;
            } else if (j > 0 && board[i][j - 1] == words[index] && search(board, stack, index, words, i, j - 1)) { //左
                return true;
            }
            Character c = stack.pop();
            board[i][j] = c;
            index--;
            return false;
        }

    }

    static class Solution5 {
        public int reverse(int x) {
//            Stack<Integer> stack = new Stack<>();
            long result = 0;
            while (x != 0) {
                result = result * 10 + (x % 10);
                x = x / 10;
            }
            return ((int) result == result) ? (int) result : 0;
        }
    }

    //11。盛最多水的容器
    static class Solution6 {
        public int maxArea(int[] height) {
            int i = 0, j = height.length - 1;
            int maxArea = Math.min(height[i], height[j]);
            while(i<j){
                if(height[i]>height[j]){
                    j--;
                    maxArea = Math.max(maxArea, (j - i) * Math.min(height[i], height[j]));
                }else{
                    i++;
                    maxArea = Math.max(maxArea, (j - i) * Math.min(height[i], height[j]));
                }
            }
            return maxArea;
        }
    }

    static class MyObj{
        @Override
        public int hashCode() {
            return 1;
        }
    }

    public static void main(String[] args) {
        HashMap map = new HashMap();
        for (int i = 0; i < 100; i++) {
            map.put(new MyObj(),1);
        }
        map.get(new MyObj());
        System.out.println();
        
//        int[] t = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
    }
}






































