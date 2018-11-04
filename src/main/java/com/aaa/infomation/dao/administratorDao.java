package com.aaa.infomation.dao;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 管理员 接口
 */
@Mapper
public interface administratorDao {

    /**
     * 管理员 登入判断
     * @param name
     * @param password
     * @return
     */
    public List<Map<String,Object>> loginAdministratorCheckNamePws(String name, String password);
}
