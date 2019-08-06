package com.spike.controller;

import java.util.Map;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.spike.model.User;
import com.spike.service.UserService;
import com.spike.util.MD5Util;
import com.spike.util.ResultResponse;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", allowCredentials = "true")
public class RegistController {
	
	private Logger logger = LoggerFactory.getLogger(RegistController.class);
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/regist", method = {RequestMethod.POST})
	public Map<String, Object> regist(@Valid @RequestBody User user, BindingResult bindingResult){
		logger.info("username"+"-"+user.getUsername()+"---------------"+ "password"+"-"+user.getPassword());
		if(bindingResult.hasErrors()) {
			ResultResponse.getResultResponse("000001", bindingResult.getAllErrors().get(0).getDefaultMessage(),null);
		}
		user.setPassword(MD5Util.inputToBack(user.getPassword()));
		userService.regist(user);		
		return ResultResponse.getResultResponse("000000", "注册成功，快去登陆吧！！！", null);
	}
	
}
