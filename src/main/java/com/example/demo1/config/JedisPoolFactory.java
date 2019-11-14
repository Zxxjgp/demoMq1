package com.example.demo1.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

@Configuration
public class JedisPoolFactory {
	@Value("${redis.host}")
	private String host;
	
	@Value("${redis.port}")
	private int port;
	
	@Value("${redis.timeout}")
	private int timeout;
	
	@Value("${redis.pool.max-active}")
	private int maxActive;
	
	@Value("${redis.pool.max-idle}")
	private int maxIdle;
	
	@Value("${redis.pool.min-idle}")
	private int minIdle;
	
	@Value("${redis.pool.max-wait}")
	private long maxWaitMillis;
	
	@Bean
	public JedisPool generateJedisPoolFactory() {
		JedisPoolConfig poolConfig = new JedisPoolConfig();
		poolConfig.setMaxTotal(maxActive);
		poolConfig.setMaxIdle(maxIdle);
		poolConfig.setMinIdle(minIdle);
		poolConfig.setMaxWaitMillis(maxWaitMillis);
		JedisPool jedisPool = new JedisPool(poolConfig, host, port, timeout);
		return jedisPool;
	}
}