package com.spike.controller;

import com.spike.model.Course;
import com.spike.service.CourseService;
import com.spike.util.CourseUtil;
import com.spike.util.ResultResponse;
import com.spike.vo.CourseDetailVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class CourseController {

    @Autowired
    private CourseService courseService;

    @RequestMapping(value = "/courseList", method = {RequestMethod.GET})
    public Map<String, Object> courseList(){

        List<Course> courseList = courseService.findAll();
        return ResultResponse.getResultResponse("200", "查询课程列表成功", courseList);

    }

    @RequestMapping(value = "/courseDetail/{courseId}", method = {RequestMethod.GET})
    public Map<String, Object> courseDetail(@PathVariable("courseId") String courseId){

        Course course = courseService.findByCourseId(courseId);
        CourseDetailVO couserDetailVO = CourseUtil.getCouserDetailVO(course);
        return ResultResponse.getResultResponse("200","查询成功",couserDetailVO);

    }

}
