package com.aaa.infomation.service;

import com.aaa.infomation.dao.iOfCourseDao;
import com.aaa.infomation.entity.iOfCourse;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 我的课程表 Service
 */
@Service
public class iOfCourseService {
    @Resource
    public iOfCourseDao iofCoursedao;

    /**
     * 添加学习课程
     *
     * @param o
     * @return
     */
    public int addOfCourse(iOfCourse o) {
        return iofCoursedao.addOfCourse(o);
    }

    /**
     * 查询我的课程
     *
     * @param usid
     * @return
     */
    public List<Map<String, Object>> showOfCourseByUsid(Integer usid) {
        if (iofCoursedao.showOfCourseByUsid(usid).size() > 0) {
            return iofCoursedao.showOfCourseByUsid(usid);
        }
        return null;
    }

    /**
     * 加入课程是否重复
     *
     * @param usid
     * @param coid
     * @return
     */
    public List<Map<String, Object>> showOfCourseByUsidAndCoid(Integer usid, Integer coid) {
        if (iofCoursedao.showOfCourseByUsidAndCoid(usid, coid).size() > 0) {
            return iofCoursedao.showOfCourseByUsidAndCoid(usid, coid);
        }
        return null;
    }
    /**
     * 根据用户主键 课程主键 修改学习进度
     * @param theProgressof
     * @param coid
     * @param usid
     * @return
     */
    public boolean updateOfCourseByUsidAndCoid(double theProgressof,Integer coid,Integer usid){
        if(iofCoursedao.updateOfCourseByUsidAndCoid(theProgressof,coid,usid)>0){
            return true;
        }
        return false;
    }
}
