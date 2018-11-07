package com.aaa.infomation.dao;

import com.aaa.infomation.entity.theCourseCatalogInfo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * 课程目录详细 接口
 */
@Mapper
public interface theCourseCatalogInfoDao {
    /**
     * 查询课程目录详细
     */
    @Select("SELECT * FROM thecoursecataloginfo a join thecoursecatalog b on\n" +
            "a.tcid=b.tcid ")
    public List<Map<String,Object>> showAlltheCourseCatalogInfo();
    /**
     * 查询课程目录详细
     */
    @Select("SELECT * FROM thecoursecataloginfo where tcid=#{param1}")
    public List<Map<String,Object>> showAlltheCourseCatalogInfofont(Integer tcid);
    /**
     * 课程详细添加
     * @param tc
     * @return
     */
    @Insert("INSERT INTO  thecoursecataloginfo(tname,tvideo,tcid,creationTime,updateTime,length) VALUES(#{tname},#{tvideo},#{tcid},NOW(),NOW(),#{length})")
    public int addCourseCatalogInfo(theCourseCatalogInfo tc);

    /**
     * 根据tcid外键 删除课程目录详细
     * @param tcid
     * @return
     */
    @Delete("DELETE FROM thecoursecataloginfo WHERE tcid=#{param1}")
    public int deleteCourseCatalogInfoByTcid(Integer tcid);
    /**
     * 根据tnid主键 删除课程目录详细
     * @param tnid
     * @return
     */
    @Delete("DELETE FROM thecoursecataloginfo WHERE tnid=#{param1}")
    public int deleteCourseCatalogInfoByTnid(Integer tnid);

    /**
     * 根据tnid主键 查询课程目录详细
     * @param tnid
     * @return
     */
    @Select("SELECT * FROM thecoursecataloginfo WHERE tnid=#{param1}")
    public List<Map<String,Object>> showThecoursecataloginfoByTnid(Integer tnid);

    /**
     * 修改课程目录详细
     * @param tc 主键
     * @return
     */
    public int updateThecoursecataloginfoByTnid(theCourseCatalogInfo tc);

    /**
     * 查询某一门课程的所有课时
     * @param coid
     * @return
     */
    @Select("SELECT c.name,h.length from  course c JOIN theCourseCatalog t on c.coid=t.coid\n" +
            "JOIN theCourseCatalogInfo h on t.tcid=h.tcid WHERE c.coid=#{param1}")
    public List<Map<String,Object>> showThecoursecataloginfoByCoid(Integer coid);

    /**
     * 根据课程目录 删除课程目录详细
     * @param tcid
     * @return
     */
    @Delete("DELETE FROM theCourseCatalogInfo WHERE tcid=#{param1}")
    public int deletetheCourseCatalogInfoByTcid(Integer tcid);

    /**
     * 查询该课时是否学习过
     * @param tnid
     * @return
     */
    @Select("SELECT * FROM theCourseCatalogInfo WHERE tnid=#{param1}")
    public List<Map<String,Object>> showtheCourseCatalogInfoByState(Integer tnid);

    /**
     * 修改已经学习过的课程
     * @param tnid
     * @return
     */
    @Select("UPDATE theCourseCatalogInfo SET state=4 WHERE tnid=#{param1}")
    public int updatetheCourseCatalogInfo(Integer tnid);

    /**
     * 取消已经学习过的课程
     * @param tnid
     * @return
     */
    @Select("UPDATE theCourseCatalogInfo SET state=3 WHERE tnid=#{param1}")
    public int updatetheCourseCatalogInfoBytnid(Integer tnid);
}
