package com.zhou.springboot.dao;

import com.zhou.springboot.bean.HasbaniSynsLog;
import com.zhou.springboot.bean.TimeOut;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@Repository
public interface TimeOutMapper extends Mapper<TimeOut> {

    int selectCount1();


    int selectTestTable();

    int testCdata(@Param("sql") String sql, @Param("id") long id, @Param("bean") OgnlBean bean);

    Map testExplain();

    String selectById(@Param("id") Integer id);

    void updateById(@Param("id") Integer id);

    void insertTimeOut(@Param("t") TimeOut timeOut);

    void lockTable();

    void unlockTable();

    void rename(@Param("original") String original, @Param("target") String target);

    List<String> selectLog(@Param("tables") String tableNames, @Param("size") Integer size);

    Integer testPresto();

    Integer testMysql();

}
