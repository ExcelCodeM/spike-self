package com.spike.redis;

import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;

public abstract class BaseRedis<T> {
	
	@Autowired
	protected RedisTemplate<String, Object> redisTemplate;
	
	@Resource
	protected HashOperations<String, String, T> hashOperations;
	
	protected abstract String getRedisKey();
	
	//存入redis
	public void put(String key, T domain, long expire){
		 hashOperations.put(getRedisKey(), key, domain);
		 if(expire != -1){
			 redisTemplate.expire(getRedisKey(), expire, TimeUnit.SECONDS);
		 }
	 }
	
	//取出redis
	public T get(String key) {
		return hashOperations.get(getRedisKey(), key);
	}

}
