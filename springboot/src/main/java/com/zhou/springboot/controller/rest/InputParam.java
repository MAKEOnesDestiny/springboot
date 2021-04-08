package com.zhou.springboot.controller.rest;


public class InputParam<T> extends CommonInfo<T> {

    private String name;

    private boolean isRequired;

    public InputParam(String name, Class<T> type, T example, String meaning, boolean isRequired) {
        super(type, example, meaning);
        this.name = name;
        this.isRequired = isRequired;
    }

    public boolean getRequired() {
        return isRequired;
    }

    public void setRequired(boolean required) {
        isRequired = required;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
