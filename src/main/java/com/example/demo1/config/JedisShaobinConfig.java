package com.example.demo1.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisSentinelPool;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * @author : CM
 * @date : 2019/3/15
 */
@Configuration
public class JedisShaobinConfig {
  /*  @Value("${spring.redis.sentinel.master}")
    private String masterName;
    @Value("${spring.redis.sentinel.nodes}")
    private String nodes;
    @Value("${spring.redis.password}")
    private String password;
    @Value("${spring.redis.database}")
    private int database;
    @Value("${spring.redis.timeout}")
    private int timeout;
    @Value("${spring.redis.jedis.pool.max-active}")
    private int maxActive;
    @Value("${spring.redis.jedis.pool.max-wait}")
    private long maxWait;
    @Value("${spring.redis.jedis.pool.max-idle}")
    private int maxIdle;

    @Bean
    JedisSentinelPool jedisSentinelPool() {
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(maxActive);
        jedisPoolConfig.setMaxWaitMillis(maxWait);
        jedisPoolConfig.setMaxIdle(maxIdle);

        Set<String> nodeSet = new HashSet<>();
        // 判断节点字符串是否为空
        if (StringUtils.isEmpty(nodes)) {
            throw new RuntimeException("RedisSentinelConfiguration initialize error nodeString is null");
        }
        String[] nodeArray = nodes.split(",");
        // 判断是否为空
        if (nodeArray.length == 0) {
            throw new RuntimeException("RedisSentinelConfiguration initialize error nodeArray is null");
        }
        // 循环注入至Set中
        Collections.addAll(nodeSet, nodeArray);
        //创建连接池对象
        return new JedisSentinelPool(masterName, nodeSet, jedisPoolConfig, timeout, password, database);
    }*/
}