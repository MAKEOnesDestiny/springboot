package com.zhou.springboot.leetcode;

public class MyCode {

    //输入一串字符，只包含“0-10”和“，”，找出其中最小的数字和最大的数字（可能不止一个），输出最后剩余数字个数，
    //如：输入“3，3，4，5，6，7，7”
    //输出最小值为3，最大值为7，剩余数字个数为3
    public static int remain(String s) {
        String[] sa = s.split(",");
        int[] c = new int[11];
        int min = 100;
        int max = -1;
        for (String ss : sa) {
            c[Integer.valueOf(ss)]++;
            min = Math.min(min, Integer.valueOf(ss));
            max = Math.max(max, Integer.valueOf(ss));
        }
        int result = 0;
        for (int i = min + 1; i < max; i++) {
            result += c[i];
        }
        return result;
    }

    //输入一组身高在170到190之间（5个身高），比较身高差，选出身高差最小的两个身高；若身高差相同，选平均身高高的那两个身高；从小到大输出；
    //如 输入 170 181 173 186 190 输出
    public static int[] findMaxDiff(int[] a) {
        int min = a[0];
        int max = a[1];
        int diff = 0;
        int i = 0;
        while (++i < a.length) {
            diff = max - min;
            if (a[i] < max && a[i] > min) {
                if ((max - a[i]) <= (a[i] - min)) {
                    min = a[i];
                } else {
                    max = a[i];
                }
            } else if (a[i] > max && (diff >= a[i] - max)) {
                min = max;
                max = a[i];
            } else if (a[i] < min && (diff >= min - a[i])) {
                max = min;
                min = a[i];
            }
        }
        return new int[]{min, max};
    }

    public static void main(String[] args) {
        int[] result = findMaxDiff(new int[]{170, 181, 173, 186, 190});
        System.out.println("");
    }

}
