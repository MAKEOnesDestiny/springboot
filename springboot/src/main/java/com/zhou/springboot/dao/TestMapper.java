package com.zhou.springboot.dao;

import java.util.Date;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TestMapper {

    Date getMaxDate(@Param("tableName") String tableName);

    //todo: 数据迁移的时候是否需要超时？
    /**
     * 从旧表转移数据到新表
     *
     * @param oldTableName 旧表
     * @param newTable     新表
     * @param step         步长
     */
    void transferData(@Param("oldTable") String oldTableName, @Param("newTable") String newTable,
                      @Param("lastUpdate") Date lastUpdate,
                      @Param("step") Integer step);

    void lockTable(@Param("lockTable")String lockTable);

    void unlockTableAndRename(@Param("lockTable")String lockTable,@Param("newTableName")String newTableName);

    void rename(@Param("oldTable") String oldTableName, @Param("newTable") String newTable);


    Long getOffset(@Param("oldTable") String oldTableName, @Param("newTable") String newTable);

}
