package com.aaa.infomation.controller;

import com.aaa.infomation.entity.iOfCourse;
import com.aaa.infomation.service.iOfCourseService;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("controlleriOfCourse")
public class iOfCourseController {
    @Resource
    public iOfCourseService iofcourseservice;

    /**
     * 添加学习课程
     * @param o
     * @return
     */
    @RequestMapping("iOfCourse")
    public @ResponseBody
    boolean addOfCourse(iOfCourse o, HttpServletRequest request){
        HttpSession session=request.getSession();
        o.setUsid(session.getAttribute("usid"));
        if( iofcourseservice.addOfCourse(o)>0){
            return  true;
        }
            return false;
    }
}