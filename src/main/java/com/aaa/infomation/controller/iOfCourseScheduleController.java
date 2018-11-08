package com.aaa.infomation.controller;

import com.aaa.infomation.service.iOfCourseScheduleService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
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
     * @param usid
     * @param tnid
     * @return
     */
    @RequestMapping("showIOfCourseScheduleByUsidAndState")
    public @ResponseBody
    List<Map<String,Object>> showIOfCourseScheduleByUsidAndState(Integer usid, Integer tnid){
        return iofcoursescheduleservice.showIOfCourseScheduleByUsidAndState(usid,tnid);
    }

    /**
     * 修改课程
     * @param usid
     * @param tnid
     * @return
     */
    @RequestMapping("updateIOfCourseSchedule")
    public @ResponseBody
    boolean updateIOfCourseSchedule(Integer state,Integer usid,Integer tnid){
        return iofcoursescheduleservice.updateIOfCourseSchedule(state,usid,tnid);
    }
}
