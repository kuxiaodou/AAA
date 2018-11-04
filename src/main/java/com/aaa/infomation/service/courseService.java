package com.aaa.infomation.service;

import com.aaa.infomation.dao.courseDao;
import com.aaa.infomation.entity.course;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 课程 Service层
 */
@Service
public class courseService {
    @Resource
    private courseDao coursedao;

    /**
     * 查询精品课程
     * @return
     */
    public List<course> showByStateCourse(Integer state){
        return coursedao.showByStateCourse(state);
    }
    /**
     * 模糊多查询 所有课程
     * @return
     */
    public List<Map<String,Object>> showCourse(Integer coid,String name,String press){
        return coursedao.showCourse(coid,name,press);
    }

    /**
     * 课程修改下架
     * @param coid
     * @return
     */
    public int updateCourseShelves(Integer coid){
        return coursedao.updateCourseShelves(coid);
    }

    /**
     * 课程修改在售
     * @param coid
     * @return
     */
    public int updateCourseSale(Integer coid){
        return coursedao.updateCourseSale(coid);
    }

    /**
     * 添加课程
     * @param c
     * @return
     */
    public int addCourse(course c){
        return coursedao.addCourse(c);
    }
    /**
     * 修改课程 根据id查询
     * @param coid
     * @return
     */
    public List<Map<String,Object>> showCourseByCoid(Integer coid){
        return  coursedao.showCourseByCoid(coid);
    }

    /**
     * 根据id修改课程
     * @param c
     * @return
     */
    public int updateCourseByCoid(course c){
        return  coursedao.updateCourseByCoid(c);
    }
    /**
     * 相关课程查询
     * @param prid
     * @return
     */
    public List<Map<String,Object>> showCourseByPrid(Integer prid){
        return coursedao.showCourseByPrid(prid);
    }
}
