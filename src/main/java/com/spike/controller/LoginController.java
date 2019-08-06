package com.spike.controller;

import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spike.model.User;
import com.spike.service.UserService;
import com.spike.util.MD5Util;
import com.spike.util.ResultResponse;
import com.spike.util.StringUtils;
import com.spike.vo.UserVO;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", allowCredentials = "true")
public class LoginController {
	
	private static Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/login", method = {RequestMethod.POST})
	public Map<String, Object> login(@Valid @RequestBody User user,  BindingResult bindingResult, HttpServletResponse response){
		//打印日志
		logger.info("username"+"-"+user.getUsername()+"---------------"+ "password"+"-"+user.getPassword());
		
		if(bindingResult.hasErrors()) {
			return ResultResponse.getResultResponse("000001", bindingResult.getAllErrors().get(0).getDefaultMessage(),null);
		}
		
		UserVO dbUser = userService.getUser(user.getUsername());
		
		if(dbUser == null) {
			return ResultResponse.getResultResponse("000002", "登陆失败，用户名不存在，请先去注册！！！",null);
		}
		if(dbUser.equals(MD5Util.inputToBack(user.getPassword()))) {
			
			//生成token，并保存到redis中
			String token = StringUtils.createUUID();
			userService.saveUserToRedisByToken(token, dbUser);
			
			//设置cookie，并保存到response中
			Cookie cookie = new Cookie("token", token);
			cookie.setMaxAge(60*60*24);
			response.addCookie(cookie);
			
		}
		logger.info("马上就要结束了！！！");
		return ResultResponse.getResultResponse("000000", "登陆成功",null);
	}
	

}
