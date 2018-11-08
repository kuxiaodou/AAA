package com.aaa.infomation.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

/**
 * 我的课程进度表 Dao层
 */
@Mapper
public interface iOfCourseScheduleDao {
    /**
     * 添加学习课程
     * @param usid
     * @param tnid
     * @param state
     * @return
     */
    @Insert("INSERT INTO iofcourseschedule(usid,tnid,state) VALUES(#{param1},#{param2},0)")
    public int addIOfCourseSchedule(Integer usid,Integer tnid);

    /**
     * 查询课程是否学习过
     * @param usid
     * @param tnid
     * @return
     */
    @Select("SELECT * FROM iofcourseschedule WHERE usid=#{param1} AND tnid=#{param2}")
    public List<Map<String,Object>> showIOfCourseScheduleByUsidAndState(Integer usid,Integer tnid);

    /**
     * 修改课程
     * @param usid
     * @param tnid
     * @return
     */
    @Update("UPDATE  iofcourseschedule SET state=#{param1} WHERE usid=#{param2} AND tnid=#{param3}")
    public int updateIOfCourseSchedule(Integer state,Integer usid,Integer tnid);
}
