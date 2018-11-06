package com.aaa.infomation.dao;
import com.aaa.infomation.entity.administrator;
import com.aaa.infomation.entity.course;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import java.util.List;
import java.util.Map;
/**
 * 教师资料表 Dao层
 */
@Mapper
public interface teachersInfoDao {
    /**
     * 查询内部教师
     * @param
     * @return
     */
    @Select("SELECT a.name as aname, a.headPortrait as aheadPortrait ,t.* FROM administrator a JOIN teachersinfo t \n" +
            "on a.adid=t.adid WHERE a.state=1")
    public List<Map<String,Object>> showTeachersInfoByAdid();

}
