package com.zhou.springboot.leqee;

public class Test {


    public static class Solution {

        /**
         * longest common substring
         *
         * @param str1 string字符串 the string
         * @param str2 string字符串 the string
         * @return string字符串
         */
        public String LCS(String str1, String str2) {
            int start = 0;
            String max = "";
            while (start < str1.length()) {
                int s2 = 0;
                int s1 = start;
                StringBuilder sb = new StringBuilder();
                while (s2 < str2.length()) {
                    if (str2.charAt(s2) != str1.charAt(s1)) {
                        s2++;
                    } else {
                        break;
                    }
                }
                while (s1 < str1.length() && s2 < str2.length()) {
                    if (str2.charAt(s2) == str1.charAt(s1)) {
                        sb.append(str1.charAt(s1));
                        s2++;
                        s1++;
                    } else {
                        break;
                    }
                }
                if (sb.length() > max.length()) {
                    max = sb.toString();
                }
                start++;
            }
            return max.length() == 0 ? "-1" : max;
        }


    }

    public static void main(String[] args) {
        System.out.println(new Solution().LCS("1AB2345CD", "12345EF"));
    }

}
