package com.zhou.springboot.test;

public class StringTest {

    public static void main(String[] args) {
        byte[] bytes = new byte[]{(byte) 0x80};
        String s = new String(bytes);
        System.out.println();
    }

}
