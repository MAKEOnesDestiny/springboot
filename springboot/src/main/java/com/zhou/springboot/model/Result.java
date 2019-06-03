package com.zhou.springboot.model;

import org.springframework.stereotype.Component;

/**
 * 返回值bean类
 *
 * @author zhou
 * @data 2018-8-9
 */
@Component
public class Result {

    public String statusCode;

    public String msg;

    public Object data;

    private Result(){}

    private Result(String statusCode, String msg, Object data) {
        this.statusCode = statusCode;
        this.msg = msg;
        this.data = data;
    }

    public static class Builder{
        //final保证线程获取到的是初始化完成的
        private final Result result;

        private Builder(){
            result = new Result();
        }

        public static Builder Builder(){
            return new Builder();
        }

        public Builder setStatusCode(String statusCode){
            result.statusCode = statusCode;
            return this;
        }

        public Builder setMsg(String msg){
            result.msg = msg;
            return this;
        }

        public Builder setData(Object data){
            result.data = data;
            return this;
        }

        public Result build(){
            return this.result;
        }


    }

}
