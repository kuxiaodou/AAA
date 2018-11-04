package com.aaa.infomation.service;

import com.aaa.infomation.dao.theCourseCatalogInfoDao;
import com.aaa.infomation.entity.theCourseCatalogInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 课程目录详细 Service层
 */
@Service
public class theCourseCatalogInfoService {
    @Resource
    private theCourseCatalogInfoDao thecoursecataloginfodao;

    /**
     * 查询课程目录详细
     */
    public List<Map<String,Object>> showAlltheCourseCatalogInfo(){
        return thecoursecataloginfodao.showAlltheCourseCatalogInfo();
    }
    /**
     * 查询课程目录详细
     */
    public List<Map<String,Object>> showAlltheCourseCatalogInfofont(Integer tcid){
        return thecoursecataloginfodao.showAlltheCourseCatalogInfofont(tcid);
    }
    /**
     * 课程详细添加
     * @param tc
     * @return
     */
    public int addCourseCatalogInfo(theCourseCatalogInfo tc){
        return thecoursecataloginfodao.addCourseCatalogInfo(tc);
    }
    /**
     * 根据tcid 删除课程目录详细
     * @param tcid 章节外键
     * @return
     */
    public int deleteCourseCatalogInfoByTcid(Integer tcid){
        return  thecoursecataloginfodao.deleteCourseCatalogInfoByTcid(tcid);
    }
    /**
     * 根据tnid 删除课程目录详细
     * @param tnid 课程目录详细主键
     * @return
     */
    public int deleteCourseCatalogInfoByTnid(Integer tnid){
        return  thecoursecataloginfodao.deleteCourseCatalogInfoByTnid(tnid);
    }
    /**
     * 根据tnid主键 查询课程目录详细
     * @param tnid
     * @return
     */
    public List<Map<String,Object>> showThecoursecataloginfoByTnid(Integer tnid){
        return thecoursecataloginfodao.showThecoursecataloginfoByTnid(tnid);
    }
    /**
     * 修改课程目录详细
     * @param tc 主键
     * @return
     */
    public int updateThecoursecataloginfoByTnid(theCourseCatalogInfo tc){
        return thecoursecataloginfodao.updateThecoursecataloginfoByTnid(tc);
    }
    /**
     * 查询某一门课程的所有课时
     * @param coid
     * @return
     */
    public List<Map<String,Object>> showThecoursecataloginfoByCoid(Integer coid){
        return thecoursecataloginfodao.showThecoursecataloginfoByCoid(coid);
    }
}
