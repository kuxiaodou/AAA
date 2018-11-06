package com.aaa.infomation.controller;

import com.aaa.infomation.service.teachersInfoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 教师资料表 Controller层
 */
@Controller
@RequestMapping("controllerTeachersInfo")
public class teachersInfoController {
    @Resource
    private teachersInfoService teachersInfoservice;
    /**
     * 查询内部教师
     * @param
     * @return
     */
     @RequestMapping("showTeachersInfoByAdid")
     @ResponseBody
     List<Map<String,Object>> showTeachersInfoByAdid(){
        return teachersInfoservice.showTeachersInfoByAdid();
    }
}
