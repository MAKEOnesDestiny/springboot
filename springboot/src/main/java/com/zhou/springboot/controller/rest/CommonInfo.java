package com.zhou.springboot.controller.rest;

public abstract class CommonInfo<T> {

    private String name;
    private Class<T> type;
    private T example;
    private String meaning;

    public CommonInfo() {
    }

    public CommonInfo(String name, Class<T> type, T example, String meaning) {
        this.name = name;
        this.type = type;
        this.example = example;
        this.meaning = meaning;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
