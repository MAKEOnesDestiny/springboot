package com.zhou.springboot.test;

import java.util.Date;

@SuppressWarnings("all")
public class MyCodeTest {

    /**
     * f(0)=0 f(1)=1 f(n)=f(n-1)+f(n-2) , n>1
     */

    //递归方式
    static class Solution {

        public int fib(int n) {
            if (n == 0) {
                return 0;
            }
            if (n == 1) {
                return 1;
            }
            return fib(n - 1) + fib(n - 2);
        }

    }

    //迭代方式
    static class Solution2 {

        public int fib(int n) {
            //f(0)=0 f(1)=1
            if (n == 0) {
                return 0;
            }
            if (n == 1) {
                return 1;
            }

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


    public static void main(String[] args) {
        System.out.println("递归方法开始时间："+new Date());
        new Solution().fib(50);
        System.out.println("递归方法结束时间："+new Date());
        System.out.println("迭代方法开始时间："+new Date());
        new Solution2().fib(50);
        System.out.println("迭代方法结束时间："+new Date());
    }


}
