package com.spike.service;

import com.spike.model.Course;
import com.spike.model.Orders;

import java.util.List;

public interface CourseService {

    public List<Course> findAll();

    Course findByCourseId(String courseId);

	public int reduceStockByCourseNo(String courseNo);

}
