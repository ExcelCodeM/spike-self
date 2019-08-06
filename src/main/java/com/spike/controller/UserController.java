package com.spike.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spike.model.User;
import com.spike.redis.UserRedis;
import com.spike.service.UserService;

@RestController
public class UserController {
	
	private static Logger logger = LoggerFactory.getLogger(UserController.class); 
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserRedis userRedis;
	
	@RequestMapping(value = "/regist111")
	public String regist(@RequestBody User user){
		//logger.info(str);
		logger.info("username"+"-"+user.getUsername()+"---------------"+ "password"+"-"+user.getPassword());
		//userService.regist(user);
		userRedis.put(user.getUsername(), user, -1);
		return "chenggong";
	}
	
	
}
