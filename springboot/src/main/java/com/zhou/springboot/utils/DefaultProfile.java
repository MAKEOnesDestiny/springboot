package com.zhou.springboot.utils;

public abstract class DefaultProfile<T> implements Profile<T>{

    protected ThreadLocal<T> threadLocal;

    protected DefaultProfile(){
    }

    protected DefaultProfile(ThreadLocal<T> th){
        threadLocal = th;
    }

    @Override
    public T nextPhase(T t) {
        throw new AbstractMethodError();
    }
}
