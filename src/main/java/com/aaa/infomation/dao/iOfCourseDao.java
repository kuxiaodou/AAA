package com.aaa.infomation.dao;

import com.aaa.infomation.entity.iOfCourse;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface iOfCourseDao {
     public List<Map<String,Object>> showiOfCourse();

    /**
     * 添加学习课程
     * @param o
     * @return
     */
     @Insert("INSERT INTO iOfCourse(coid,usid,theProgressof,creationTime,updateTime) \n" +
             "VALUES(#{coid},#{usid},#{theProgressof},NOW(),NOW())")
     public int addOfCourse(iOfCourse o);
}
