package com.aaa.infomation.controller;

import com.aaa.infomation.entity.iOfCourse;
import com.aaa.infomation.entity.user;
import com.aaa.infomation.service.iOfCourseScheduleService;
import com.aaa.infomation.service.iOfCourseService;
import com.aaa.infomation.service.theCourseCatalogInfoService;
import com.aaa.infomation.service.userService;
import com.aaa.infomation.util.SmsVerification;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 用户 Controller层
 */
@Controller
@RequestMapping("controllerUser")
public class userController {
    @Resource
    private userService userservice;
    @Resource
    public iOfCourseService iofcourseservice;
    @Resource
    private iOfCourseScheduleService iofcoursescheduleservice;
    @Resource
    private theCourseCatalogInfoService thecoursecataloginfoservice;
    SmsVerification sm;

    /**
     * 查询全部用户
     *
     * @param page
     * @param limit
     * @return
     */
    @RequestMapping(value = "showAllUser")
    public @ResponseBody
    Map<String, Object> showAllUser(int page, int limit, String name, Integer position) {
        Page startPage = PageHelper.startPage(page, limit);
        List<List<Map<String, Object>>> news = userservice.showAllUser(name, position);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("code", "0");
        map.put("data", news);
        map.put("count", startPage.getTotal());
        map.put("msg", "");
        return map;
    }

    /**
     * 更新用户状态 打开禁用
     *
     * @param usid
     * @return
     */
    @RequestMapping(value = "updateUserStateOpenDisable")
    public @ResponseBody
    Integer updateUserStateOpenDisable(Integer usid, HttpServletRequest request) {
        Object adid = request.getSession().getAttribute("loginAdminAdid");
        if (userservice.updateUserStateOpenDisable(adid, usid) > 0) {
            return 1;
        }
        return null;
    }

    /**
     * 更新用户状态 关闭禁用
     *
     * @param usid
     * @return
     */
    @RequestMapping(value = "updateUserStateCloseDisable")
    public @ResponseBody
    Integer updateUserStateCloseDisable(Integer usid, HttpServletRequest request) {
        Object adid = request.getSession().getAttribute("loginAdminAdid");
        if (userservice.updateUserStateCloseDisable(adid, usid) > 0) {
            return 1;
        }
        return null;
    }

    /**
     * 登录
     *
     * @return
     */
    @RequestMapping("login")
    public @ResponseBody
    boolean login(String names, String password, HttpServletRequest request) {
        List<user> list = userservice.login(names, password);
        HttpSession session = request.getSession();
        if (list.size() > 0) {
            session.setAttribute("userlogin", list);
            return true;
        } else {
            return false;
        }
    }

    /**
     * 显示登录信息
     *
     * @return
     */
    @RequestMapping("logins")
    @ResponseBody
    public List<user> logins(HttpServletRequest request) {
        HttpSession session = request.getSession();
        List<user> lsit = (List<user>) session.getAttribute("userlogin");
        return lsit;
    }

    /**
     * 点击课程 查询用户是否登入 添加学习课程
     *
     * @param request
     * @return
     */
    @RequestMapping("selectLoginUser")
    @ResponseBody
    public Integer selectLoginUser(HttpServletRequest request, iOfCourse o) {
        try {
            int num = 0;
            HttpSession session = request.getSession();
            List<user> lsit = (List<user>) session.getAttribute("userlogin");
            List<Map<String, Object>> listCourseInfo = thecoursecataloginfoservice.showThecoursecataloginfoByCoid(o.getCoid());
            System.out.println(lsit);
            System.out.println(listCourseInfo);
            if (null != lsit && lsit.size() > 0 && null != listCourseInfo && listCourseInfo.size() > 0) {
                o.setUsid(lsit.get(0).getUsid());
                for (int i = 0; i < listCourseInfo.size(); i++) {
                    if (iofcoursescheduleservice.addIOfCourseSchedule((Integer)listCourseInfo.get(i).get("tnid"), o.getCoid())) {
                        num = 1;
                    } else {
                        num = 0;
                    }
                }
                if (iofcourseservice.addOfCourse(o) > 0 && num > 0) {
                    return 1;
                } else {
                    return 2;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @RequestMapping("phone")
    @ResponseBody
    public int phone(String phone) {
        System.out.println(phone);
        return sm.getVerificationCode(phone);
    }

    @RequestMapping("addUser")
    public @ResponseBody
    boolean addUser(user u) {
        int rs = userservice.addUser(u);
        if (rs > 0) {
            return true;
        } else {
            return false;
        }
    }
}
