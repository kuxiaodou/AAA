package com.aaa.infomation.service;
import com.aaa.infomation.dao.courseqaDao;
import com.aaa.infomation.entity.courseqa;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
/**
 *课程问答 Service层
 */
@Service
public class courseqaService {
    @Resource
    private courseqaDao courseqadao;

    /**
     * 每一门 课程问答查询
     * @param coid
     * @return
     */
    public List<Map<String,Object>> showCourseqa(Object coid){
        return  courseqadao.showCourseqa(coid);
    }
    /**
     * 添加 课程问答
     * @param c
     * @return
     */
    public int addCourseqa(courseqa c){
        return  courseqadao.addCourseqa(c);
    }
}
