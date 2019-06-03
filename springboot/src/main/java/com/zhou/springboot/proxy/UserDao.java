package com.zhou.springboot.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class UserDao implements IUserDao {
    @Override
    public void doWork() {
        System.out.println("user defined class UserDao do work...");
    }

    public static void main(String[] args) {
        Object proxy = Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(), new Class[]{IUserDao.class}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Object result;
                System.out.println("method before enhanced...");
                result = method.invoke(proxy, args);
                System.out.println("method after enhanced...");
                return result;
            }
        });
        System.out.println(1);
    }


}
