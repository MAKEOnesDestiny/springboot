package com.zhou.springboot.redis;

import org.springframework.util.CollectionUtils;
import redis.clients.jedis.HostAndPort;

import java.util.ArrayList;
import java.util.List;

public class RedisClusterConfig {

    private List<HostAndPort> hostAndPorts = new ArrayList<>();

    public RedisClusterConfig(String... hostAndPort) {
        List<String> strList = CollectionUtils.arrayToList(hostAndPort);
        strList.forEach((t) -> {
            String[] address = t.split(":");
            hostAndPorts.add(new HostAndPort(address[0], Integer.valueOf(address[1])));
        });
    }

    public HostAndPort findOne(){
        return hostAndPorts.get(0);
    }



}
