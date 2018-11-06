package com.aaa.infomation.dao;

import com.aaa.infomation.entity.administrator;
import com.aaa.infomation.entity.course;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

/**
 * 课程 dao层
 */
@Mapper
public interface courseDao {
    /**
     * 查询精品课程
     * @return
     */
    @Select("SELECT * FROM COURSE WHERE STATE=#{param1}")
    public List<course> showByStateCourse(Integer state);

    /**
     * 模糊多查询 所有课程
     * @return
     */
    public List<Map<String,Object>> showCourse(Integer coid, String name, String press);
    /**状态
     * 课程修改下架
     * @param coid
     * @return
     */
    @Update("UPDATE course SET STATE=4 WHERE COID=#{param1}")
    public int updateCourseShelves(Integer coid);

    /**状态
     * 课程修改在售
     * @param coid
     * @return
     */
    @Update("UPDATE course SET STATE=1 WHERE COID=#{param1} ")
    public int updateCourseSale(Integer coid);

    /**
     * 添加课程
     * @param c
     * @return
     */
    @Insert("INSERT INTO course (name,courseFee,theCumulativePurchase,press,courseOverview,\n" +
            "picture,video,usid,state,creationTime,updateTime,prid,adid) VALUES(#{name},#{courseFee},#{theCumulativePurchase},#{courseOverview},#{press},\n" +
            "#{picture},#{video},#{usid},#{state},NOW(),NOW(),#{prid},#{adid})")
    public int addCourse(course c);

    /**
     * 修改课程 根据id查询
     * @param coid
     * @return
     */
    @Select("SELECT * FROM course WHERE coid=#{param1}")
    public List<Map<String,Object>> showCourseByCoid(Integer coid);

    /**
     * 根据id修改课程
     * @param c
     * @return
     */
    public int updateCourseByCoid(course c);

    /**
     * 相关课程查询
     * @param prid
     * @return
     */
    @Select("SELECT * FROM course WHERE prid=#{param1}  LIMIT 0,3")
    public List<Map<String,Object>> showCourseByPrid(Integer prid);

    /**
     * 根据课程外键删除课程
     * @param coid
     * @return
     */
    @Delete("DELETE FROM course WHERE coid=#{param1}")
    public int delteCourseByCoid(Integer coid);

    /**
     * 根据老师 查询老师所教课程
     * @param adid
     * @return
     */
    @Select("SELECT a.name as aname, a.headPortrait as aheadPortrait ,a.adid as aadid ,t.* ,c.coid as ccoid ,c.name  as cname,c.courseFee,c.  theCumulativePurchase, c.press,c.courseOverview,c.picture,c.video,c.usid,c.state,c.creationTime\n" +
            "as uscreationTime , c.updateTime as usupdateTime FROM administrator a JOIN teachersinfo t\n" +
            "on a.adid=t.adid JOIN course c on a.adid=c.adid\n" +
            "WHERE a.state=1  and a.adid=#{param1}")
    public List<Map<String,Object>> showTeachersInfoByAdid(Integer adid);
}
