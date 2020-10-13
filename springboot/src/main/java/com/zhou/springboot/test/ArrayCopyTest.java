package com.zhou.springboot.test;


import com.zhou.springboot.model.TestBean;
import java.util.Arrays;

public class ArrayCopyTest {

    //Arrays.copyOf是浅拷贝(非基本类型)
    //对于基本类型来说，不存在浅拷贝还是深拷贝一说，因为栈上的值就是最终我们要找的数据
    public static void main(String[] args) {
        TestBean t1 = new TestBean();
        t1.name = "t1的name";
        TestBean[] tt = new TestBean[]{t1};
        TestBean[] ttCopy = Arrays.copyOf(tt,2);
        System.out.println();

    }


}
