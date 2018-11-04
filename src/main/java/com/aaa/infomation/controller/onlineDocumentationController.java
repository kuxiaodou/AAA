package com.aaa.infomation.controller;

import com.aaa.infomation.entity.onlineDocumentation;
import com.aaa.infomation.entity.onlinetype;
import com.aaa.infomation.service.onlineDocumentationService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("document")
public class onlineDocumentationController {
    @Resource
    private onlineDocumentationService service;

    /*
    * 文档分类
    * */
    @RequestMapping("/showtype")
    @ResponseBody
    public List<onlinetype> showtype(){
        return service.showtype();
    }
    /*
    * 根据id进行查询文档的类型
    * */
    @RequestMapping("/query_type")
    @ResponseBody
    public List<Map<String,Object>> query_type(String type){
        return service.query_type(type);
    }
    /*
     * 热门文档目录
     * */
    @RequestMapping("/query_catalogue")
    @ResponseBody
    public List<Map<String,Object>> query_catalogue(String type){
        return service.query_catalogue(type);
    }
    /*
     * 文档目录查询
     * */
    @RequestMapping("/query_catalogues")
    @ResponseBody
    public List<Map<String,Object>> query_catalogues(String type){
        return service.query_catalogues(type);
    }
    /*
     * 热门文档目录
     * */
    @RequestMapping("/catalogue_type")
    @ResponseBody
    public List<Map<String,Object>> catalogue_type(String type,Integer types){
        return service.catalogue_type(type,types);
    }
    /*
     * 文档目录查询
     * */
    @RequestMapping("/catalogue_types")
    @ResponseBody
    public List<Map<String,Object>> catalogue_types(String type,Integer types){
        return service.catalogue_types(type,types);
    }
    /*
     * 按标题进行查询
     * */
    @RequestMapping("/query_title")
    @ResponseBody
    public List<Map<String,Object>> query_title(Integer caid){
        return service.query_title(caid);
    }
    /*
     * 增加浏览次数
     * */
    @RequestMapping("/addviewcont")
    @ResponseBody
    public boolean addviewcont(Integer view,Integer caid){
        if(view==null && caid==null){
            return service.addviewcont(view,caid);
        }else{
            return service.addviewcont(view+1,caid);
        }
    }
    /*
     * 增加目录浏览次数
     * */
    @RequestMapping("/addviewconts")
    @ResponseBody
    public boolean addviewconts(Integer view,Integer onid){
        if(view==null && onid==null){
            return true;
        }else{
            return service.addviewconts(view+1,onid);
        }
    }
    /*
    * 根据id查询文档内容
    * */
    @RequestMapping("/show_documents")
    @ResponseBody
    public List<onlineDocumentation> show_documents(Integer onid){
        return service.show_documents(onid);
    }
    /*
     * 添加收藏
     * */
    @RequestMapping("/Addcollections")
    @ResponseBody
    public boolean Addcollections(Integer caid,Integer usid){
        if(caid==null && usid==null){
            return true;
        }else{
            return service.Addcollections(caid,usid);
        }
    }
    /*
     * 取消收藏
     * */
    @RequestMapping("/Deletecollections")
    @ResponseBody
    public boolean Deletecollections(Integer caid,Integer usid){
        if(caid==null && usid==null){
            return true;
        }else{
            return service.Deletecollections(caid,usid);
        }
    }
    /*
     * 修改收藏次数
     * */
    @RequestMapping("/Update_context")
    @ResponseBody
    public boolean Update_context(Integer caid,Integer collect,Integer id){
        if(id==1){
            return service.Update_context(caid,collect+1);
        }else{
            return service.Update_context(caid,collect-1);
        }
    }
    /*
     * 点击标题判断是否收藏
     * */
    @RequestMapping("/collection")
    @ResponseBody
    public boolean collection(Integer caid,Integer usid){
        if(usid!=null && caid!=null){
            return service.collection(caid,usid);
        }else{
            return false;
        }
    }
}