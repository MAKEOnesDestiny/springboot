package com.zhou.springboot.bean;

import com.zhou.springboot.anno.ParamInfo;

public class TestMvcSonBean {

    @ParamInfo(meaning = "son的id", example = "456")
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
