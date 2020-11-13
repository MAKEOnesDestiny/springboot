package com.zhou.springboot.easyexcel;


import com.alibaba.excel.annotation.ExcelProperty;
import com.zhou.springboot.easyexcel.converter.DateTypeConverter;

public class TestBean {

    @ExcelProperty("唯一编号")
    private String id;

    @ExcelProperty(value = "名称", converter = DateTypeConverter.class)
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
