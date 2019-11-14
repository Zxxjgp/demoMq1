package com.example.demo1.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/*@Component*/
public class RedisUtil {
	/*@Autowired*/
	private JedisPool jedisPool;
	
	/**
	 * 存储字符串键值对
	 * @param key
	 * @param value
	 * @return
	 * @author hw
	 * @date 2018年12月14日
	 */
	public String set(String key, String value) throws Exception {
		Jedis jedis = jedisPool.getResource();
		try {
			return jedis.set(key, value);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		} finally {
			jedis.close();
		}
	}

	/**
	 * 得到对应键的字符串值
	 * @param key
	 * @return
	 * @author hw
	 * @date 2018年12月14日
	 */
	public String get(String key) throws Exception {
		Jedis jedis = jedisPool.getResource();
		try {
			return jedis.get(key);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		} finally {
			jedis.close();
		}
	}

	/**
	 * 删除字符串键值对
	 * @param key
	 * @return
	 * @author hw
	 * @date 2018年12月14日
	 */
	public Long del(String key) throws Exception {
		Jedis jedis = jedisPool.getResource();
		try {
			return jedis.del(key);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		} finally {
			jedis.close();
		}
	}

}