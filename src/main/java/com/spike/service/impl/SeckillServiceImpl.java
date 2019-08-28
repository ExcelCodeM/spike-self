package com.spike.service.impl;

import java.util.Date;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spike.model.Course;
import com.spike.model.Orders;
import com.spike.model.User;
import com.spike.service.CourseService;
import com.spike.service.ISeckillService;
import com.spike.service.OrderService;
import com.spike.util.ResultResponse;

@Service
public class SeckillServiceImpl implements ISeckillService {
	
	@Autowired
	private CourseService courseService;
	
	@Autowired
	private OrderService orderService;
	
	@Override
	public Map<String, Object> seckillFlow(User user, String courseNo) {
		//1,先判断课程是否有库存
		Course selCourse = courseService.findByCourseId(courseNo);
		if(selCourse != null) {
			return ResultResponse.getResultResponse("100002", "购买的课程不存在！！！", null);
		}
		int stockQuantity = selCourse.getStockQuantity();
		if(stockQuantity <= 0) {
			return ResultResponse.getResultResponse("100003", "需要购买的课程已经没有余量了！！！", null);
		}
		//2,判断用户是否已经购买过次课程
		Orders order = orderService.getOrderByUsernameAndCourseNo(user.getUsername(), courseNo);
		if(order != null) {
			return ResultResponse.getResultResponse("100004", "课程已经购买！！！", null);
		}
		//3,减库存 下订单
		Orders newOrder = seckill(user, selCourse);
		return null;
	}
	
	public Orders seckill(User user, Course course) {
		int secuess = courseService.reduceStockByCourseNo(course.getCourseNo());
		if(secuess > 0) {
			Orders newOrder = new Orders();
			BeanUtils.copyProperties(course, newOrder);
			newOrder.setUsername(user.getUsername());
			newOrder.setCreatBy(user.getUsername());
			newOrder.setCreateDate(new Date());
			newOrder.setCoursePrice(course.getCourcePrice());
			newOrder.setPayStatus("0");
			return orderService.saveAndFlush(newOrder);
		}
		return null;
	}
}
