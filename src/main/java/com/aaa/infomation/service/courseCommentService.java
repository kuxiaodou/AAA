package com.aaa.infomation.service;

import com.aaa.infomation.dao.courseCommentDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 课程评论 Service层
 */
@Service
public class courseCommentService {
    @Resource
    private courseCommentDao coursedommentdao;

    /**
     * 课程评论添加
     * @param star
     * @param context
     * @param coid
     * @return
     */
    public int addCourseComment(String star,String context,Integer coid, Object usid){
        return  coursedommentdao.addCourseComment(star,context,coid,usid);
    }
    /**
     * 查询所有评论
     * @return
     */
    public List<Map<String,Object>> showCourseComment(){
        return  coursedommentdao.showCourseComment();
    }
}
