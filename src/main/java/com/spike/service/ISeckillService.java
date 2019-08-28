package com.spike.service;

import java.util.Map;

import com.spike.model.User;

public interface ISeckillService {

	Map<String, Object> seckillFlow(User user, String courseNo);

}
