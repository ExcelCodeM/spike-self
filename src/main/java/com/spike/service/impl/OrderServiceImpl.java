package com.spike.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spike.model.Orders;
import com.spike.repository.OrdersRepository;
import com.spike.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	private OrdersRepository ordersRepository;

	@Override
	public Orders getOrderByUsernameAndCourseNo(String username, String courseNo) {
		return ordersRepository.findByUsernameAndCourseNo(username, courseNo);
		
	}

	@Override
	public Orders saveAndFlush(Orders newOrder) {
		return ordersRepository.saveAndFlush(newOrder);
	}

}
