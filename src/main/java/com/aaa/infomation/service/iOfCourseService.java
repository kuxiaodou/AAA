package com.aaa.infomation.service;

import com.aaa.infomation.dao.iOfCourseDao;
import com.aaa.infomation.entity.iOfCourse;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class iOfCourseService {
    @Resource
    public iOfCourseDao iofCoursedao;

    /**
     * 添加学习课程
     * @param o
     * @return
     */
    public int addOfCourse(iOfCourse o){
        return  iofCoursedao.addOfCourse(o);
    }
}
