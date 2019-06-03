package com.zhou.springboot.test;

import com.zhou.springboot.dao.TestMapper;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class CollectionTest {

    public static void main(String[] args) {
        /*int[] intList = new int[]{};
        System.out.println(intList.length);
        intList[1]=2;*/
        Object o = Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(), new Class[]{TestMapper.class}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println(proxy.getClass());
                System.out.println(method.getName());
                return null;
            }
        });
        ((TestMapper)o).selectModultIdByUserLoginId("111");


    }

}
