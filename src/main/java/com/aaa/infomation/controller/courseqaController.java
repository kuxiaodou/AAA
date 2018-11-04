package com.aaa.infomation.controller;

import com.aaa.infomation.entity.courseqa;
import com.aaa.infomation.service.courseqaService;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/**
 * 课程问答 Controller层
 */
@Controller
@RequestMapping("controllerCourseqa")
public class courseqaController {
    @Resource
    private courseqaService courseqaservive;

    /**
     * 每一门 课程问答查询
     * @param request
     * @return
     */
    @RequestMapping("showCourseqa")
    public @ResponseBody
    List<Map<String, Object>> showCourseqa(HttpServletRequest request) {
        HttpSession session = request.getSession();
        Object usid = session.getAttribute("usid");
        if(null!=usid&&null!=usid){
            return courseqaservive.showCourseqa(request.getSession().getAttribute("usid"));
        }
        return null;
    }

    /**
     * 添加 课程问答
     * @param request
     * @param c
     * @return
     */
    @RequestMapping("addCourseqa")
    public @ResponseBody
    boolean addCourseqa(courseqa c, HttpServletRequest request) {
        HttpSession session = request.getSession();
        Object usid = session.getAttribute("usid");
        System.out.println(usid);
        c.setUsid(usid);
        if (courseqaservive.addCourseqa(c) > 0 && null != usid && usid != null) {
            return true;
        }
        return false;
    }
}
