package com.aaa.infomation.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * 课程评论 接口
 */
@Mapper
public interface courseCommentDao {
    /**
     * 课程评论添加
     * @param star
     * @param context
     * @param coid
     * @return
     */
    @Insert("INSERT INTO courseComment(star,context,coid,usid,creationTime) " +
            "VALUES(#{param1},#{param2},#{param3},#{param3},NOW())")
    public int addCourseComment(String star, String context, Integer coid, Object usid);

    /**
     * 查询所有评论
     * @return
     */
    @Select("SELECT u.name,u.headPortrait,c.star,c.context,c.creationTime FROM coursecomment c JOIN user u \n" +
            "on c.usid=u.usid")
    public List<Map<String,Object>> showCourseComment();
}
