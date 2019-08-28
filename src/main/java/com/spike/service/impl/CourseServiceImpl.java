package com.spike.service.impl;

import com.alibaba.fastjson.JSON;
import com.spike.model.Course;
import com.spike.redis.CourseRedis;
import com.spike.repository.CourseRepository;
import com.spike.service.CourseService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private CourseRedis courseRedis;

    private static final String ALL_COURSE_REDIS = "AllCourseRedis";

    @Override
    public List<Course> findAll() {

        List<Course> courseList = new ArrayList<Course>();

        String courseListStr = courseRedis.getString(ALL_COURSE_REDIS);

        if (StringUtils.isEmpty(courseListStr)) {
            courseList = courseRepository.findAll();
            String courseJSONString = JSON.toJSONString(courseList);
            courseRedis.putString(ALL_COURSE_REDIS, courseJSONString, -1);
        }else{
            courseList = JSON.parseArray(courseListStr, Course.class);
        }

        return courseList;
    }

    @Override
    public Course findByCourseId(String courseId) {
        Optional<Course> course = courseRepository.findById(courseId);
        return course.orElse(null);
    }

	@Override
	public int reduceStockByCourseNo(String courseNo) {
		int secuess = courseRepository.reduceStockByCourseNo(courseNo);
		return 0;
	}


}
