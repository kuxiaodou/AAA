package com.aaa.infomation.service;

import com.aaa.infomation.dao.iOfCourseScheduleDao;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 我的课程进度表 Service层
 */
@Service
public class iOfCourseScheduleService {
    @Resource
    private iOfCourseScheduleDao iOfcoursescheduledao;

    /**
     * 添加学习课程
     *
     * @param usid
     * @param tnid
     * @return
     */
    public boolean addIOfCourseSchedule(Integer usid, Integer tnid) {
        if (iOfcoursescheduledao.addIOfCourseSchedule(usid, tnid) > 0) {
            return true;
        }
        return false;
    }

    /**
     * 查询课程是否学习过
     *
     * @param usid
     * @param tnid
     * @return
     */
    public List<Map<String, Object>> showIOfCourseScheduleByUsidAndState(Integer usid, Integer tnid) {
        if (iOfcoursescheduledao.showIOfCourseScheduleByUsidAndState(usid, tnid).size() > 0) {
            return iOfcoursescheduledao.showIOfCourseScheduleByUsidAndState(usid, tnid);
        }
        return null;
    }

    /**
     * 修改课程
     *
     * @param usid
     * @param tnid
     * @return
     */
    public boolean updateIOfCourseSchedule(Integer state, Integer usid, Integer tnid) {
        if (iOfcoursescheduledao.updateIOfCourseSchedule(state, usid, tnid) > 0) {
            return true;
        }
        return false;
    }

    /**
     * 查看用户学习所有课程
     *
     * @param usid
     * @return
     */
    public List<Map<String, Object>> showIOfCourseScheduleByUsidFont(Integer usid) {
        if (iOfcoursescheduledao.showIOfCourseScheduleByUsidFont(usid).size() > 0) {
            return iOfcoursescheduledao.showIOfCourseScheduleByUsidFont(usid);
        }
        return null;
    }
    /**
     * 查看用户学习没有学过课程
     * @param usid
     * @return
     */
    public List<Map<String,Object>> showIOfCourseScheduleByUsidBack(Integer usid){
        if (iOfcoursescheduledao.showIOfCourseScheduleByUsidBack(usid).size() > 0) {
            return iOfcoursescheduledao.showIOfCourseScheduleByUsidBack(usid);
        }
        return null;
    }
}
