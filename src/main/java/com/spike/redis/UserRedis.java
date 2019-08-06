package com.spike.redis;

import org.springframework.stereotype.Component;

import com.spike.model.User;

@Component
public class UserRedis extends BaseRedis<User> {
	
	private static final String REDIS_KEY = "com.spike.redis.UserRedis";
	
	@Override
	protected String getRedisKey() {
		return REDIS_KEY;
	}

}
