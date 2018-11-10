package com.aaa.infomation.controller;

import com.aaa.infomation.entity.user;
import com.aaa.infomation.service.iOfCourseScheduleService;
import com.aaa.infomation.service.iOfCourseService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/**
 * 我的课程进度表 Controller层
 */
@Controller
@RequestMapping("controllerIOfCourseSchedule")
public class iOfCourseScheduleController {
    @Resource
    private iOfCourseScheduleService iofcoursescheduleservice;
    @Resource
    public iOfCourseService iofcourseservice;
    /**
     * 添加学习课程
     * @param usid
     * @param tnid
     * @return
     */
    @RequestMapping("addIOfCourseSchedule")
    public @ResponseBody
    boolean addIOfCourseSchedule(Integer usid,Integer tnid){
        return iofcoursescheduleservice.addIOfCourseSchedule(usid,tnid);
    }

    /**
     * 查询课程是否学习过
     * @param tnid
     * @return
     */
    @RequestMapping("showIOfCourseScheduleByUsidAndState")
    public @ResponseBody
    boolean showIOfCourseScheduleByUsidAndState(Integer tnid, HttpServletRequest request){
        HttpSession session = request.getSession();
        List<user> lsit = (List<user>) session.getAttribute("userlogin");
        if(null!=lsit&&lsit.size()>0){
            if(iofcoursescheduleservice.showIOfCourseScheduleByUsidAndState(lsit.get(0).getUsid(),tnid).get(0).get("state").equals(1)){
                return true;
            }
        }
        return false;
    }

    /**
     * 修改课程
     * @param tnid
     * @return
     */
    @RequestMapping("updateIOfCourseSchedule")
    public @ResponseBody
    boolean updateIOfCourseSchedule(Integer tnid, HttpServletRequest request,Integer coid){
        HttpSession session = request.getSession();
        List<user> lsit = (List<user>) session.getAttribute("userlogin");
        double numback;
        double numfont;
        if(null!=lsit&&lsit.size()>0){
            List<Map<String, Object>> listSchedulefont=iofcoursescheduleservice.showIOfCourseScheduleByUsidFont(lsit.get(0).getUsid());
            numfont=listSchedulefont.size();
            if(iofcoursescheduleservice.updateIOfCourseSchedule(1,lsit.get(0).getUsid(),tnid)){
                List<Map<String, Object>> listScheduleback=iofcoursescheduleservice.showIOfCourseScheduleByUsidBack(lsit.get(0).getUsid());
                numback=listScheduleback.size();
                double num=100/(numfont/numback);
                if(iofcourseservice.updateOfCourseByUsidAndCoid(num,coid,lsit.get(0).getUsid())){
                    return true;
                }else{
                    return false;
                }
            }
        }
        return false;
    }
}
