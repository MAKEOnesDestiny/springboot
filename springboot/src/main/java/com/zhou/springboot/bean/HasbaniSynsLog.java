package com.zhou.springboot.bean;

import javax.persistence.Entity;

@Entity
public class HasbaniSynsLog {

    public String date;

    public String tableName;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }
}
