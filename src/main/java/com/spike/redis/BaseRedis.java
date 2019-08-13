package com.spike.redis;

import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

public abstract class BaseRedis<T> {
	
	@Autowired
	protected RedisTemplate<String, Object> redisTemplate;
	
	@Resource
	protected HashOperations<String, String, T> hashOperations;

	@Resource
	protected ValueOperations<String, Object> valueOperations;
	
	protected abstract String getRedisKey();

	//存入redis, String
	public void putString(String key, Object domain, long expire){
		valueOperations.set(key, domain);
		if(expire != -1){
			redisTemplate.expire(getRedisKey(), expire, TimeUnit.SECONDS);
		}
	}

	public String getString(String key){
		return (String) valueOperations.get(key);
	}
	
	//存入redis, hashOperations
	public void put(String key, T domain, long expire){
		 hashOperations.put(getRedisKey(), key, domain);
		 if(expire != -1){
			 redisTemplate.expire(getRedisKey(), expire, TimeUnit.SECONDS);
		 }
	}
	
	//取出redis, hashOperations
	public T get(String key) {
		return hashOperations.get(getRedisKey(), key);
	}

}
