package com.aaa.infomation.dao;

import com.aaa.infomation.entity.user;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

/**
 *用户 用户dao层
 */
@Mapper
public interface userDao {
    /**
     * 多条件查询 用户
     * @return
     */
    public List<List<Map<String,Object>>> showAllUser(String name, Integer position);

    /**
     * 更新用户状态 打开禁用
     * @param usid
     * @return
     */
    @Update("UPDATE user set state=0,updateTime=NOW(),adid=#{param1} WHERE usid=#{param2}")
    public int updateUserStateOpenDisable(Object adid, Integer usid);
    /**
     * 更新用户状态 关闭禁用
     * @param usid
     * @return
     */
    @Update("UPDATE user set state=1,updateTime=NOW(),adid=#{param1} WHERE usid=#{param2}")
    public int updateUserStateCloseDisable(Object adid, Integer usid);

    /**
     * 登录
     * @return
     */
    @Select(value = "SELECT * FROM USER where name=#{param1} and password=#{param2}")
    public List<user> login(String name, String password);
}
