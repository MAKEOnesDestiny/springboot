package com.zhou.springboot.controller.rest;

public abstract class CommonInfo<T> {

    private Class<T> type;
    private T example;
    private String meaning;

    public CommonInfo() {
    }

    public CommonInfo(Class<T> type, T example, String meaning) {
        this.type = type;
        this.example = example;
        this.meaning = meaning;
    }

    public Class<T> getType() {
        return type;
    }

    public void setType(Class<T> type) {
        this.type = type;
    }

    public T getExample() {
        return example;
    }

    public void setExample(T example) {
        this.example = example;
    }

    public String getMeaning() {
        return meaning;
    }

    public void setMeaning(String meaning) {
        this.meaning = meaning;
    }
}
