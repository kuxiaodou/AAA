package com.aaa.infomation.controller;

import com.aaa.infomation.entity.iOfCourse;
import com.aaa.infomation.entity.user;
import com.aaa.infomation.service.iOfCourseService;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/**
 * 我的课程表 Controller层
 */
@Controller
@RequestMapping("controlleriOfCourse")
public class iOfCourseController {
    @Resource
    public iOfCourseService iofcourseservice;

    /**
     * 添加学习课程
     *
     * @param o
     * @return
     */
    @RequestMapping("iOfCourse")
    public @ResponseBody
    boolean addOfCourse(iOfCourse o, HttpServletRequest request) {
        HttpSession session = request.getSession();
        o.setUsid(session.getAttribute("usid"));
        if (iofcourseservice.addOfCourse(o) > 0) {
            return true;
        }
        return false;
    }

    /**
     * 查询我的课程
     *
     * @return
     */
    @RequestMapping("showOfCourseByUsid")
    public @ResponseBody
    List<Map<String, Object>> showOfCourseByUsid(HttpServletRequest request) {
        HttpSession session = request.getSession();
        List<user> lsit = (List<user>) session.getAttribute("userlogin");
        if( null != lsit && lsit.size() > 0){
            return iofcourseservice.showOfCourseByUsid(lsit.get(0).getUsid());
        }
        return null;
    }
}
