package com.aaa.infomation.controller;

import com.aaa.infomation.service.administratorService;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 管理员 Controller层
 */
@Controller
@RequestMapping("controllerAdministrator")
public class administratorController {
    @Resource
    private administratorService administratorservice;

    /**
     * 管理员 登入判断
     * @return
     */
    @RequestMapping("loginAdministratorCheckNamePwd")
    public @ResponseBody
    List<Map<String,Object>> loginAdministratorCheckNamePwd(String name, String password,HttpServletRequest request){
        List<Map<String,Object>> listloginAdministratorCheckNamePwd=administratorservice.loginAdministratorCheckNamePws(name,password);
        if(listloginAdministratorCheckNamePwd.size()>0){
            request.getSession().setAttribute("loginAdmin",listloginAdministratorCheckNamePwd);
            request.getSession().setAttribute("loginAdminAdid",listloginAdministratorCheckNamePwd.get(0).get("adid"));
        }
        return listloginAdministratorCheckNamePwd;
    }

    /**
     * 显示登入的用户
     * @param request
     * @return
     */
    @RequestMapping("loginAdministratorCheckNamePwsShowAll")
    public @ResponseBody
    Object loginAdministratorCheckNamePwsShowAll(HttpServletRequest request){
        return request.getSession().getAttribute("loginAdmin");
    }

    /**
     * 用户 退出销毁session
     * @return
     */
    @RequestMapping("exitAdministrator")
    public String exitAdministrator(HttpServletRequest request){
        request.getSession().invalidate();
        return "login.html";
    }
}
