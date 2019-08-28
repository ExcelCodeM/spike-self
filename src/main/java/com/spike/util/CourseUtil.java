package com.spike.util;

import com.spike.model.Course;
import com.spike.vo.CourseDetailVO;

public class CourseUtil {

    public static final int COURSE_NOT_START = 0;
    public static final int COURSE_PROCESSING = 1;
    public static final int COURSE_COMPLETE = 2;


    public static CourseDetailVO getCouserDetailVO(Course course){

        CourseDetailVO courseDetailVO = new CourseDetailVO();
        courseDetailVO.setCourse(course);

        long startTime = course.getStartTime().getTime();
        long endTime = course.getEndTime().getTime();
        long nowTime = System.currentTimeMillis();

        int courseStatus = 0;
        int remainTime = 0;

        if(nowTime < startTime){
            courseStatus = COURSE_NOT_START;
            remainTime = (int) ((startTime-nowTime)/1000);
        }else if(nowTime > endTime){
            courseStatus = COURSE_COMPLETE;
            remainTime = -1;
        }else{
            courseStatus = COURSE_PROCESSING;
            remainTime = -1;
        }

        courseDetailVO.setCourseStatus(courseStatus);
        courseDetailVO.setRemainTime(remainTime);

        return courseDetailVO;

    }
}
