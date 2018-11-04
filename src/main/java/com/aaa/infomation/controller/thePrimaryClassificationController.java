package com.aaa.infomation.controller;

import com.aaa.infomation.entity.thePrimaryClassification;
import com.aaa.infomation.service.thePrimaryClassificationService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * 一级课程分类  Controller层
 */
@Controller
@RequestMapping("controllerThePrimaryClassification")
public class thePrimaryClassificationController {
    @Resource
    private thePrimaryClassificationService thePrimaryClassificationservice;

    /**
     * 查询一级课程分类
     * @param
     * @return
     */
    @RequestMapping("showAllthePrimaryClassification")
    public @ResponseBody
    List<thePrimaryClassification> showAllthePrimaryClassification(){
        List<thePrimaryClassification> listshowAllthePrimaryClassification=thePrimaryClassificationservice.showAllthePrimaryClassification();
        return listshowAllthePrimaryClassification;
    }
}
