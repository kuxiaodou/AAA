package com.aaa.infomation.dao;
import com.aaa.infomation.entity.courseqa;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import java.util.List;
import java.util.Map;

/**
 * 课程问答 Dao层
 */
@Mapper
public interface courseqaDao {
    /**
     * 每一门 课程问答查询
     * @param coid
     * @return
     */
    @Select("SELECT * FROM courseqa c JOIN user u on \n" +
            "c.usid=u.usid WHERE coid=#{param1}")
    public List<Map<String,Object>> showCourseqa(Object coid);
    /**
     * 添加 课程问答
     * @param c
     * @return
     */
    @Insert("INSERT INTO courseqa(coid,usid,title,context,creationTime) VALUES(#{coid},#{usid},#{title},#{context},NOW())")
    public int addCourseqa(courseqa c);
}
