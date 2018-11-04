package com.aaa.infomation.controller;

import com.aaa.infomation.service.courseCommentService;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/**
 * 课程评论 Controller层
 */
@Controller
@RequestMapping("controllerCourseComment")
public class courseCommentController {
    @Resource
    private courseCommentService coursecommentsercice;

    /**
     * 课程评论添加
     *
     * @param star
     * @param context
     * @param coid
     * @param request
     * @return
     */
    @RequestMapping("addCourseComment")
    public @ResponseBody
    boolean addCourseComment(String star, String context, Integer coid, HttpServletRequest request) {
        HttpSession session = request.getSession();
        Object usid = session.getAttribute("usid");
        //Object id=null;
		/*if(null!=coid&&coid!=null){
			id=usid;
			return  false;
		}*/
        if (null != usid && usid != null && coursecommentsercice.addCourseComment(star, context, coid, usid) > 0) {
            return true;
        }
        return false;
    }

    /**
     * 查询所有评论
     *
     * @return
     */
    @RequestMapping("showCourseComment")
    public @ResponseBody
    List<Map<String, Object>> showCourseComment() {
        return coursecommentsercice.showCourseComment();
    }
}
