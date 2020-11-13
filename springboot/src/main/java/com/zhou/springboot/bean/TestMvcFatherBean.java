package com.zhou.springboot.bean;

public class TestMvcFatherBean {

    private TestMvcSonBean son;

    private Integer fId;

    public Integer getfId() {
        return fId;
    }

    public void setfId(Integer fId) {
        this.fId = fId;
    }

    public TestMvcSonBean getSon() {
        return son;
    }

    public void setSon(TestMvcSonBean son) {
        this.son = son;
    }
}
