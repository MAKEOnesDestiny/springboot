package com.zhou.springboot.dao;

import com.zhou.springboot.bean.TimeOut;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@Repository
public interface TimeOutMapper extends Mapper<TimeOut> {

    int selectCount1();


    int selectTestTable();

    int testCdata(@Param("sql") String sql, @Param("id") long id, @Param("bean") OgnlBean bean);

    String testExplain();

}
