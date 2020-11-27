package com.zhou.springboot.bean;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class TimeOut {

    @Id
    private Integer id;

    private String testName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTestName() {
        return testName;
    }

    public void setTestName(String testName) {
        this.testName = testName;
    }

    @Override
    public String toString() {
        return "TimeOut{" +
                "id=" + id +
                ", testName='" + testName + '\'' +
                '}';
    }
}
