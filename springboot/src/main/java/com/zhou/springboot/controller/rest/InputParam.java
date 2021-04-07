package com.zhou.springboot.controller.rest;


public class InputParam<T> extends CommonInfo<T> {

    private String name;

    private Boolean isRequired;

    public InputParam(String name, Class<T> type, T example, String meaning, Boolean isRequired) {
        super(type, example, meaning);
        this.name = name;
        this.isRequired = isRequired;
    }

    public Boolean getRequired() {
        return isRequired;
    }

    public void setRequired(Boolean required) {
        isRequired = required;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
