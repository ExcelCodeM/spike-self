package com.spike.controller;

import com.spike.model.Course;
import com.spike.service.CourseService;
import com.spike.util.ResultResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", allowCredentials = "true")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @RequestMapping(value = "/courseList", method = {RequestMethod.GET})
    public Map<String, Object> courseList(@Valid @RequestBody Course course, BindingResult bindingResult){
        if(bindingResult.hasErrors()) {
            return ResultResponse.getResultResponse("000001", bindingResult.getAllErrors().get(0).getDefaultMessage(),null);
        }

        List<Course> courseList = courseService.findAll();

        return ResultResponse.getResultResponse("000000", "查询课程列表成功", courseList);

    }

}
