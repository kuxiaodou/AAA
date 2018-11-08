package com.aaa.infomation.service;

import com.aaa.infomation.dao.iOfCourseDao;
import com.aaa.infomation.entity.iOfCourse;
import org.apache.ibatis.annotations.Select;
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
}
