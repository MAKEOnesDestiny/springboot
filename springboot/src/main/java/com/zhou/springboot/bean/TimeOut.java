package com.zhou.springboot.bean;

public class TimeOut {

    private int id;

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
