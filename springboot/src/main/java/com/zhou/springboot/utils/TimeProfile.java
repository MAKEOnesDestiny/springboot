package com.zhou.springboot.utils;

public class TimeProfile extends DefaultProfile<Long> {

    public TimeProfile(){
        super(new ThreadLocal<Long>(){
            @Override
            protected Long initialValue() {
                return System.currentTimeMillis();
            }
        });
    }

    @Override
    public Long begin() {
        threadLocal.set(System.currentTimeMillis());
        return threadLocal.get();
    }

    @Override
    public Long end() {
        return System.currentTimeMillis() - threadLocal.get();
    }

}
