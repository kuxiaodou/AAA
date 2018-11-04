package com.aaa.infomation.service;

import com.aaa.infomation.dao.onlineDocumentationDao;
import com.aaa.infomation.entity.onlineDocumentation;
import com.aaa.infomation.entity.onlinetype;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class onlineDocumentationService {
    @Resource
    private onlineDocumentationDao dao;

    /*
     * 查询文档的分类
     * */
    public List<onlinetype> showtype(){
        return dao.showtype();
    }
    /*
     * 根据id进行查询文档的类型
     * */
    public List<Map<String,Object>> query_type(String type){
        return dao.query_type(type);
    }
    /*
     * 热门文档目录
     * */
    public List<Map<String,Object>> query_catalogue(String type){
        return dao.query_catalogue(type);
    }
    /*
     * 文档目录查询
     * */
    public List<Map<String,Object>> query_catalogues(String type){
        return dao.query_catalogues(type);
    }
    /*
     * 热门文档目录
     * */
    public List<Map<String,Object>> catalogue_type(String type,Integer types){
        return dao.catalogue_type(type,types);
    }
    /*
     * 文档目录查询
     * */
    public List<Map<String,Object>> catalogue_types(String type,Integer types){
        return dao.catalogue_types(type,types);
    }
    /*
     * 按标题进行查询
     * */
    public List<Map<String,Object>> query_title(Integer caid){
        return dao.query_title(caid);
    }
    /*
     * 增加浏览次数
     * */
    public boolean addviewcont(Integer view,Integer caid){
        return dao.addviewcont(view,caid);
    }
    /*
     * 增加目录浏览次数
     * */
    public boolean addviewconts(Integer view,Integer onid){
        return dao.addviewconts(view,onid);
    }
    /*
     * 根据id进行查询内容
     * */
    public List<onlineDocumentation> show_documents(Integer onid){
        return dao.show_documents(onid);
    }
    /*
     * 添加收藏
     * */
    public boolean Addcollections(Integer caid,Integer usid){
        return dao.Addcollections(caid,usid);
    }
    /*
     * 取消收藏
     * */
    public boolean Deletecollections(Integer caid,Integer usid){
        return dao.Deletecollections(caid,usid);
    }
    /*
     * 修改收藏次数
     * */
    public boolean Update_context(Integer caid,Integer collect){
        return dao.Update_context(caid,collect);
    }
    /*
     * 点击标题判断是否收藏
     * */
    public boolean collection(Integer caid,Integer usid){
        List<Map<String,Object>> list=dao.collection(caid,usid);
        if(list.size()>0){
            return true;
        }else{
            return false;
        }
    }
}