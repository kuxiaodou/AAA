package com.aaa.infomation.dao;

import com.aaa.infomation.entity.thePrimaryClassification;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 一级课程分类 接口
 */
@Mapper
public interface thePrimaryClassificationDao {
    /**
     * 查询一级课程分类
     *
     * @return
     */
    @Select("SELECT * FROM thePrimaryClassification")
    public List<thePrimaryClassification> showAllthePrimaryClassification();
}
