package com.aaa.infomation.dao;

import com.aaa.infomation.entity.theCourseCatalog;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

/**
 *课程目录 dao层
 */
@Mapper
public interface theCourseCatalogDao {
    /**
     * 查询某一门课程目录
     * @param coid
     * @return
     */
    @Select("SELECT t.*,c.name  as cname,c.courseFee,c.theCumulativePurchase,\n" +
            "c.press,c.courseOverview,c.picture,c.video,c.usid,c.state,c.creationTime\n" +
            "as uscreationTime , c.updateTime as usupdateTime,a.headPortrait as aheadPortrait,\n" +
            "e.introduction as eintroduction,a.name as aname,h.name as hname,h.prid as hprid  FROM theCourseCatalog \n" +
            "t right JOIN course c on\n" +
            "t.coid=c.coid right JOIN administrator a \n" +
            "on c.adid=a.adid right JOIN teachersInfo e\n" +
            "on a.adid=e.adid right JOIN thePrimaryClassification h\n" +
            "on c.prid=h.prid\n" +
            "WHERE C.coid=#{coid}")
    public List<Map<String,Object>> showtheCourseCataloByCoid(Integer coid);

    /**
     * 添加课程目录
     * @param c
     * @return
     */
    @Insert("INSERT INTO  theCourseCatalog(name,coid,creationTime,updateTime) VALUES(#{name},#{coid},NOW(),NOW())")
    public int addCourseCatalog(theCourseCatalog c);

    /**
     * 根据 ID 课程目录删除
     * @param tcid
     * @return
     */
    @Delete("DELETE FROM thecoursecatalog WHERE tcid=#{param1}")
    public int deleteCourseCatalogByTcid(Integer tcid);

    /**
     * 根据ID 修改课程目录信息
     * @param t
     * @return
     */
    @Update("UPDATE theCourseCatalog SET name=#{name},updateTime=NOW() WHERE tcid=#{tcid} ")
    public int updatetheCourseCataloByTcid(theCourseCatalog t);

    /**
     * 根据ID 查询课程目录
     * @param tcid
     * @return
     */
    @Select("SELECT * FROM theCourseCatalog WHERE tcid=#{param1} ")
    public List<Map<String,Object>> showtheCourseCataloByTcid(Integer tcid);
}
