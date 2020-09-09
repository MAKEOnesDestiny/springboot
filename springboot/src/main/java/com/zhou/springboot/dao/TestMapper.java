package com.zhou.springboot.dao;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

//@Repository
public interface TestMapper{

//    @Select("select module_id from tbl_mybatis where user_login_id=#{userLoginId}")
    public String selectModultIdByUserLoginId(String userLoginId);

}
