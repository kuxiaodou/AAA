package com.aaa.infomation.dao;

import com.aaa.infomation.entity.onlineDocumentation;
import com.aaa.infomation.entity.onlinetype;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

/*
* 在线文档  dao层
* */
@Mapper
public interface onlineDocumentationDao {
    /*
    * 查询文档的分类
    * */
    @Select("select * from onlinetype")
    public List<onlinetype> showtype();
    /*
    * 根据id进行查询文档的类型
    * */
    @Select("select m.maid,m.type matype,m.odid modid,c.type cltype," +
            "c.odid clodid,o.odid onodid,o.type ontype from majortype m " +
            "left join classiftype c on m.odid=c.odid left join " +
            "onlinetype o on m.odid=o.odid where o.type=#{type}")
    public List<Map<String,Object>> query_type(String type);
    /*
     * 热门文档目录
     * */
    @Select("select c.caid,c.title,c.explain,c.usid,c.adid,c.viewcont,c.collect,c.type catype," +
            "c.types,c.major,c.money,c.creationTime," +
            "c.updateTime,o.odid ondid,o.type ontype,m.maid,m.type matype," +
            "m.odid maodid from catalogue c left join onlinetype o on c.type=o.odid " +
            "left join majortype m on c.major=m.maid where o.type=#{type} " +
            "order by c.viewcont desc limit 5")
    public List<Map<String,Object>> query_catalogue(String type);
    /*
     * 文档目录查询
     * */
    @Select("select c.caid,c.title,c.explain,c.usid,c.adid,c.viewcont,c.collect,c.type catype," +
            "c.types,c.major,c.money,c.creationTime,c.updateTime," +
            "o.odid ondid,o.type ontype,m.maid,m.type matype,m.odid maodid from " +
            "catalogue c left join onlinetype o on c.type=o.odid left join majortype m " +
            "on c.major=m.maid where o.type=#{type} " +
            "order by c.creationTime desc")
    public List<Map<String,Object>> query_catalogues(String type);
    /*
     * 热门文档目录
     * */
    @Select("select c.caid,c.title,c.explain,c.usid,c.adid,c.viewcont,c.collect,c.type catype," +
            "c.types,c.major,c.money,c.creationTime," +
            "c.updateTime,o.odid ondid,o.type ontype,m.maid,m.type matype," +
            "m.odid maodid from catalogue c left join onlinetype o on c.type=o.odid " +
            "left join majortype m on c.major=m.maid where m.type=#{param1} " +
            "and m.odid=#{param2} order by c.viewcont desc limit 5")
    public List<Map<String,Object>> catalogue_type(String type, Integer types);
    /*
     * 文档目录查询
     * */
    @Select("select c.caid,c.title,c.explain,c.usid,c.adid,c.viewcont,c.collect,c.type catype," +
            "c.types,c.major,c.money,c.creationTime,c.updateTime," +
            "o.odid ondid,o.type ontype,m.maid,m.type matype,m.odid maodid from " +
            "catalogue c left join onlinetype o on c.type=o.odid left join majortype m " +
            "on c.major=m.maid where m.type=#{param1} " +
            "and m.odid=#{param2} order by c.creationTime desc")
    public List<Map<String,Object>> catalogue_types(String type, Integer types);
    /*
    * 按标题进行查询
    * */
    @Select("select ca.caid cacid,ca.title catitle,ca.explain,ca.usid," +
            "ca.adid,ca.viewcont caview,ca.collect,ca.type,ca.types,ca.major,ca.money," +
            "ca.creationTime catime,ca.updateTime cauptime,ol.onid," +
            "ol.title oltitle,ol.caid olcaid,ol.context,ol.viewconts," +
            "ol.creationTime oltime,ol.updateTime oluptime from " +
            "onlineDocumentation ol left join catalogue ca on ol.caid=ca.caid " +
            "where ca.caid=#{caid}")
    public List<Map<String,Object>> query_title(Integer caid);
    /*
    * 增加标题浏览次数
    * */
    @Update("update catalogue set viewcont=#{param1} where caid=#{param2}")
    public boolean addviewcont(Integer view, Integer caid);
    /*
     * 增加目录浏览次数
     * */
    @Update("update onlinedocumentation set viewconts=#{param1} where onid=#{param2}")
    public boolean addviewconts(Integer view, Integer onid);
    /*
     * 根据id进行查询内容
     * */
    @Select("select * from onlineDocumentation where onid=#{onid}")
    public List<onlineDocumentation> show_documents(Integer onid);
    /*
    * 添加收藏
    * */
    @Insert("insert into collectionofdocuments values(DEFAULT,#{param1},#{param2})")
    public boolean Addcollections(Integer caid, Integer usid);
    /*
     * 取消收藏
     * */
    @Delete("delete from collectionofdocuments where caid=#{param1} and usid=#{param2}")
    public boolean Deletecollections(Integer caid, Integer usid);
    /*
     * 修改收藏次数
     * */
    @Update("update catalogue set collect=#{param2} where caid=#{param1}")
    public boolean Update_context(Integer caid, Integer collect);
    /*
    * 点击标题判断是否收藏,查询到值就是已收藏
    * */
    @Select("select * from collectionofdocuments where caid=#{param1} and usid=#{param2}")
    public List<Map<String,Object>> collection(Integer caid, Integer usid);
}