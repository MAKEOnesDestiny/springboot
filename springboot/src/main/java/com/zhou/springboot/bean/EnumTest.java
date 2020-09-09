package com.zhou.springboot.bean;

import com.zhou.springboot.dao.TestMapper;

public enum EnumTest implements TestMapper {
    TYPE1{
        @Override
        public String selectModultIdByUserLoginId(String userLoginId) {
            return super.selectModultIdByUserLoginId(userLoginId);
        }
    };

    @Override
    public String selectModultIdByUserLoginId(String userLoginId) {
        return null;
    }


}
