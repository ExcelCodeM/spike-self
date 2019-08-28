package com.spike.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spike.model.User;
import com.spike.service.ISeckillService;
import com.spike.util.ResultResponse;

@RestController
@CrossOrigin
@RequestMapping(value = "/api")
public class SeckillController {
	
	@Autowired
	private ISeckillService seckillService;
	
	@RequestMapping(value = "seckill/{courseNo}", method = RequestMethod.GET)
	public Map<String, Object> seckill(User user, @PathVariable String courseNo){
		if(user == null) {
			return ResultResponse.getResultResponse("100001", "请先登录！！！", null);
		}
		return seckillService.seckillFlow(user, courseNo);
	}
}
