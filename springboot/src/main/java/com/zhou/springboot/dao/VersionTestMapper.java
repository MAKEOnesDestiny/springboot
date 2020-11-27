package com.zhou.springboot.dao;

import com.zhou.springboot.bean.VersionTest;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@Repository
public interface VersionTestMapper extends Mapper<VersionTest> {

    void updateByKey(@Param("id") int id, @Param("value") String value);

    void updateByKeyVersion(@Param("id") int id, @Param("value") String value,@Param("version")int version);

}
