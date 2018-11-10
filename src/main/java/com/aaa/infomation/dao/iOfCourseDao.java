package com.aaa.infomation.dao;

import com.aaa.infomation.entity.iOfCourse;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

/**
 * 我的课程表 Dao层
 */
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

    /**
     * 查询我的课程
     * @param usid
     * @return
     */
     @Select("SELECT i.ioid,i.usid  as ausid, i.theProgressof, c.* FROM iOfCourse i\n" +
             "JOIN course c on i.coid=c.coid WHERE i.usid=#{param1}")
     public List<Map<String,Object>> showOfCourseByUsid(Integer usid);

    /**
     * 加入课程是否重复
     * @param usid
     * @param coid
     * @return
     */
     @Select("SELECT * FROM iofcourse WHERE coid=#{param1} AND usid=#{param2}")
     public List<Map<String,Object>> showOfCourseByUsidAndCoid(Integer coid,Integer usid);

    /**
     * 根据用户主键 课程主键 修改学习进度
     * @param theProgressof
     * @param coid
     * @param usid
     * @return
     */
     @Update("UPDATE iofcourse SET theProgressof=#{param1} WHERE coid=#{param2} AND usid=#{param2}")
     public int updateOfCourseByUsidAndCoid(double theProgressof,Integer coid,Integer usid);
}
