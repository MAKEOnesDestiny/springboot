package com.zhou.springboot.controller.rest;


public class InputParam<T> extends CommonInfo<T> {

    private Boolean isRequired;

    public InputParam(String name, Class<T> type, T example, String meaning, Boolean isRequired) {
        super(name, type, example, meaning);
        this.isRequired = isRequired;
    }

    public Boolean getRequired() {
        return isRequired;
    }

    public void setRequired(Boolean required) {
        isRequired = required;
    }
}
