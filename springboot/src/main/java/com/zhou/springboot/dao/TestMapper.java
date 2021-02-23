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

    //todo : 如果碰到 删除/修改 的情况怎么保证数据的可靠性
    //todo : 删除考虑 切换过后，在手动进行对比删除(人工核对)   更新考虑 将更新转换成删除后插入
    void transferDataWithTimeOut(@Param("oldTable") String oldTableName, @Param("newTable") String newTable,
                                 @Param("lastUpdate") Date lastUpdate,
                                 @Param("step") Integer step);

    void deleteDirty(@Param("oldTable") String oldTableName, @Param("newTable") String newTable,
                     @Param("lastUpdate") Date lastUpdate,
                     @Param("step") Integer step);

    void lockTable(@Param("lockTable")String lockTable);

//    void unlockTableAndRename(@Param("lockTable")String lockTable,@Param("newTableName")String newTableName);
    void unlockTable(@Param("lockTable")String lockTable);

    void renameTable(@Param("oldTableName")String oldTableName,@Param("newTableName")String newTableName);

    Long getOffset(@Param("oldTable") String oldTableName, @Param("newTable") String newTable);

}
