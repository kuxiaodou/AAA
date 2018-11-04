package com.aaa.infomation.service;

import com.aaa.infomation.dao.userDao;
import com.aaa.infomation.entity.user;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 用户 service层
 */
@Service
public class userService {
    /**
     * 用户接口
     */
    @Resource
    private userDao userdao;

    /**
     * 查询所有用户方法
     * @return
     */
    public List<List<Map<String,Object>>> showAllUser(String name, Integer position){
        return userdao.showAllUser(name,position);
    }
    /**
     * 更新用户状态 打开禁用
     * @param usid
     * @return
     */
    public int updateUserStateOpenDisable(Object adid,Integer usid){
        return userdao.updateUserStateOpenDisable(adid,usid);
    }
    /**
     * 更新用户状态 关闭禁用
     * @param usid
     * @return
     */
    public int updateUserStateCloseDisable(Object adid,Integer usid){
        return userdao.updateUserStateCloseDisable(adid,usid);
    }
    /**
     * 登录
     * @return
     */
    public List<user> login(String name, String password){
        return userdao.login(name,password);
    }
}
