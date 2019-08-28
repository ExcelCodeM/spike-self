package com.spike.service;

import com.spike.model.Orders;

public interface OrderService {

	Orders getOrderByUsernameAndCourseNo(String username, String courseNo);

	Orders saveAndFlush(Orders newOrder);

}
