package com.aaa.infomation.controller;

import com.aaa.infomation.entity.iOfCourse;
import com.aaa.infomation.entity.user;
import com.aaa.infomation.service.iOfCourseService;
import com.aaa.infomation.service.userService;
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
    /**
     * 查询全部用户
     * @param page
     * @param limit
     * @return
     */
    @RequestMapping(value="showAllUser")
    public @ResponseBody
    Map<String,Object> showAllUser(int page, int limit,String name,Integer position){
        Page startPage = PageHelper.startPage(page,limit);
        List<List<Map<String,Object>>> news=userservice.showAllUser(name,position);
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("code","0");
        map.put("data",news);
        map.put("count",startPage.getTotal());
        map.put("msg","");
      System.out.println(news);
        return map;
    }
    /**
     * 更新用户状态 打开禁用
     * @param usid
     * @return
     */
    @RequestMapping(value="updateUserStateOpenDisable")
    public @ResponseBody
    Integer updateUserStateOpenDisable(Integer usid, HttpServletRequest request){
        Object adid=request.getSession().getAttribute("loginAdminAdid");
        if(userservice.updateUserStateOpenDisable(adid,usid)>0){
            return 1;
        }
        return null;
    }
    /**
     * 更新用户状态 关闭禁用
     * @param usid
     * @return
     */
    @RequestMapping(value="updateUserStateCloseDisable")
    public @ResponseBody
    Integer updateUserStateCloseDisable(Integer usid,HttpServletRequest request){
        Object adid=request.getSession().getAttribute("loginAdminAdid");
        if(userservice.updateUserStateCloseDisable(adid,usid)>0){
            return 1;
        }
        return null;
    }
    /**
     * 登录
     * @return
     */
    @RequestMapping("login")
    public String login(String names, String password, HttpServletRequest request){
        List<user> list=userservice.login(names,password);
        HttpSession session=request.getSession();
        session.setAttribute("usid",list.get(0).getUsid());
        session.setAttribute("name",list.get(0).getName());
        System.out.println(list.get(0).getUsid());
        if(list.size()>0){
            return "redirect:/articlelist.html";
        }else{
            return "redirect:/index.html";
        }
    }
    /**
     * 显示登录信息
     * @return
     */
    @RequestMapping("logins")
    @ResponseBody
    public Map<String,Object> logins(HttpServletRequest request){
        HttpSession session=request.getSession();
        if(session.getAttribute("usid")!=null && session.getAttribute("name")!=null){
            Integer usid=Integer.parseInt(session.getAttribute("usid").toString());
            String name=session.getAttribute("name").toString();
            Map<String,Object> list=new HashMap<>();
            list.put("usid",usid);
            list.put("name",name);
            return list;
        }else{
            return null;
        }
    }

    /**
     * 点击课程 查询用户是否登入 添加学习课程
     * @param request
     * @return
     */
    @RequestMapping("selectLoginUser")
    @ResponseBody
    public Integer selectLoginUser(HttpServletRequest request,iOfCourse o){
        try {
            HttpSession session=request.getSession();
            if(null!=session.getAttribute("usid")&&session.getAttribute("usid")!=null){
                o.setUsid(session.getAttribute("usid"));
                if( iofcourseservice.addOfCourse(o)>0){
                    return  1;
                }else{
                    return 2;
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return 0;
    }
}
