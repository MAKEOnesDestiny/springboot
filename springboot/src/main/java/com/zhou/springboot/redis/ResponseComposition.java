package com.zhou.springboot.redis;

import redis.clients.jedis.Response;

import java.util.List;

public class ResponseComposition<T extends List> extends Response<T> {

    private List<Response> responseList;

    public ResponseComposition(List<Response> responseList) {
        super(null);
        this.responseList = responseList;
    }

    @Override
    public T get() {
        return (T) responseList;
    }

    @Override
    public void set(Object data) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void setDependency(Response dependency) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String toString() {
        return responseList == null ? getClass().getName() + '@' + Integer.toHexString(hashCode()) : responseList.toString();
    }
}
