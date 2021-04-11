package com.zhou.springboot.controller.rest;

public class OutputInfo<T> extends CommonInfo<T>{

    private String name;

    public OutputInfo(Class<T> type, T example, String meaning, String name) {
        super(type, example, meaning);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
