package com.zhou.springboot.bean;

import com.zhou.springboot.anno.ParamInfo;

public class TestMvcFatherBean {

    //    @ParamInfo(complexInfo = TestMvcSonBean.class)
    private TestMvcSonBean son;

    @ParamInfo(example = "123", meaning = "父亲id", required = true)
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
