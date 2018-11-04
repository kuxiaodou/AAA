package com.aaa.infomation.service;
import com.aaa.infomation.dao.administratorDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
/**
 * 管理员 Service层
 */
@Service
public class administratorService {
    @Resource
    private administratorDao administratordao;

    /**
     * 管理员 登入判断
     * @param name
     * @param password
     * @return
     */
    public List<Map<String,Object>> loginAdministratorCheckNamePws(String name, String password){
         return administratordao.loginAdministratorCheckNamePws(name,password);
    }
}
