package com.aaa.infomation.service;

import com.aaa.infomation.dao.theCourseCatalogDao;
import com.aaa.infomation.entity.theCourseCatalog;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 课程目录 Service层
 */
@Service
public class theCourseCatalogService {
    @Resource
    private theCourseCatalogDao thecoursecatalogdao;

    /**
     * 查询某一门课程目录
     * @param coid
     * @return
     */
    public List<Map<String,Object>> showtheCourseCataloByCoid(Integer coid){
        return thecoursecatalogdao.showtheCourseCataloByCoid(coid);
    }
    /**
     * 添加课程目录
     * @param c
     * @return
     */
    public int addCourseCatalog(theCourseCatalog c){
        return thecoursecatalogdao.addCourseCatalog(c);
    }
    /**
     * 根据 ID 课程目录删除
     * @param tcid
     * @return
     */
    public int deleteCourseCatalogByTcid(Integer tcid){
        return  thecoursecatalogdao.deleteCourseCatalogByTcid(tcid);
    }
    /**
     * 根据ID 修改课程目录信息
     * @param t
     * @return
     */
    public int updatetheCourseCataloByTcid(theCourseCatalog t){
        return thecoursecatalogdao.updatetheCourseCataloByTcid(t);
    }
    /**
     * 根据ID 查询课程目录
     * @param tcid
     * @return
     */
    public List<Map<String,Object>> showtheCourseCataloByTcid(Integer tcid){
        return  thecoursecatalogdao.showtheCourseCataloByTcid(tcid);
    }
    /**
     * 根据课程主键  查询课程目录
     * @param coid
     * @return
     */
    public List<theCourseCatalog> selecttheCourseCatalogCoid(Integer coid){
        return  thecoursecatalogdao.selecttheCourseCatalogCoid(coid);
    }

    /**
     * 根据课程主键  删除课程目录
     * @param coid
     * @return
     */
    public int deletetheCourseCatalogByCoid(Integer coid){
        return  thecoursecatalogdao.deletetheCourseCatalogByCoid(coid);
    }
}
