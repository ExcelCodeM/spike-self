package com.spike.redis;

import com.spike.model.Course;
import org.springframework.stereotype.Component;

@Component
public class CourseRedis extends BaseRedis<Course> {

    private static final String COURSE_REDIS = "com.spike.redis.CourseRedis";

    @Override
    public String getRedisKey() {
        return COURSE_REDIS;
    }
}
