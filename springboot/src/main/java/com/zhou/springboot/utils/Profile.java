package com.zhou.springboot.utils;

public interface Profile<T> {

    T begin();

    T end();

    T nextPhase(T t);

}
