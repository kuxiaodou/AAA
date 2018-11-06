package com.aaa.infomation.service;
import com.aaa.infomation.dao.teachersInfoDao;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
/**
 * 教师资料表 Service层
 */
@Service
public class teachersInfoService {
    @Resource
    private teachersInfoDao teachersInfodao;
    /**
     * 查询内部教师
     * @param
     * @return
     */
    public List<Map<String,Object>> showTeachersInfoByAdid(){
        return teachersInfodao.showTeachersInfoByAdid();
    }
}
