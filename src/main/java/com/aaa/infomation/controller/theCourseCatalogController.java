package com.aaa.infomation.controller;

import com.aaa.infomation.entity.theCourseCatalog;
import com.aaa.infomation.entity.theCourseCatalogInfo;
import com.aaa.infomation.service.theCourseCatalogInfoService;
import com.aaa.infomation.service.theCourseCatalogService;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * 课程 Controller层
 */
@Controller
@RequestMapping("controllerTheCourseCatalog")
public class theCourseCatalogController {
    @Resource
    private theCourseCatalogService thecoursecatalogservice;
    @Resource
    private theCourseCatalogInfoService thecoursecataloginfoservice;
    private Integer coids;//课程主键

    public Integer getCoids() {
        return coids;
    }

    public void setCoids(Integer coids) {
        this.coids = coids;
    }

    /**
     * 查询课程目录
     *
     * @param coid
     * @return
     */
    @RequestMapping("showtheCourseCataloByCoid")
    public @ResponseBody
    List<Map<String, Object>> showtheCourseCataloByCoid(Integer coid) {
        List<Map<String, Object>> listTheCourseCataloByCoid = thecoursecatalogservice.showtheCourseCataloByCoid(coid);
        coids = coid;
        return listTheCourseCataloByCoid;
    }

    /**
     * 添加 查询课程目录
     *
     * @return
     */
    @RequestMapping("showtheCourseCataloByCoidAdd")
    public @ResponseBody
    List<Map<String, Object>> showtheCourseCataloByCoidAdd() {
        List<Map<String, Object>> listTheCourseCataloByCoid = thecoursecatalogservice.showtheCourseCataloByCoid(coids);
        return listTheCourseCataloByCoid;
    }

    /**
     * 添加课程目录
     *
     * @param
     * @param name
     * @return
     */
    @RequestMapping("addCourseCatalog")
    public @ResponseBody
    Integer addCourseCatalog(String name) {
        theCourseCatalog tc = new theCourseCatalog();
        tc.setName(name);
        tc.setCoid(coids);
        if (thecoursecatalogservice.addCourseCatalog(tc) > 0) {
            return coids;
            //"redirect:/back/course-list-info.html?coid="+coids;
        }
        return null;
    }

    /**
     * 添加课程详细目录
     *
     * @param file
     * @param request
     * @param tname
     * @param tcid
     * @return
     */
    @RequestMapping("addCourseCatalogInfo")
    public @ResponseBody
    Integer addCourseCatalogInfo(@RequestParam("file") MultipartFile file, HttpServletRequest request, String tname, Integer tcid,String length) {
        theCourseCatalogInfo tc = new theCourseCatalogInfo();
        if (!file.isEmpty()) {
            try {
                String upl = request.getSession().getServletContext().getRealPath("/") + "video/";
                File dir = new File(upl);
                String name = file.getOriginalFilename();
                String uuidss = UUID.randomUUID().toString() + ".mp4";
                tc.setTvideo("video/" + uuidss);
                tc.setTname(tname);
                tc.setTcid(tcid);
                tc.setLength(length);
                File ser = new File(upl + uuidss);
                file.transferTo(ser);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
            if (thecoursecataloginfoservice.addCourseCatalogInfo(tc) > 0) {
                System.out.println("上传成功");
                return coids;
            } else {
                return null;
            }
        } else {
            return null;
        }
    }

    /**
     * 根据 ID 课程目录以及目录详细删除
     *
     * @param tcid
     * @return
     */
    @RequestMapping("deleteCourseCatalogOnCourseCatalogInfoByTcid")
    public @ResponseBody
    Integer deleteCourseCatalogOnCourseCatalogInfoByTcid(Integer tcid, Integer coid) {
        // System.out.println(tcid);
        if (thecoursecatalogservice.deleteCourseCatalogByTcid(tcid) > 0 && thecoursecataloginfoservice.deleteCourseCatalogInfoByTcid(tcid) > 0) {
            return coid;
        }
        return null;
    }

    /**
     * 根据ID 查询课程目录
     *
     * @param tcid
     * @return
     */
    @RequestMapping("showtheCourseCataloByTcid")
    public @ResponseBody
    List<Map<String, Object>> showtheCourseCataloByTcid(Integer tcid) {
        List<Map<String, Object>> listShowtheCourseCataloByTcid = thecoursecatalogservice.showtheCourseCataloByTcid(tcid);
        return listShowtheCourseCataloByTcid;
    }
    /**
     * 根据ID 修改课程目录信息
     * @param t
     * @return
     */
    @RequestMapping("updatetheCourseCataloByTcid")
    public @ResponseBody
    Integer updatetheCourseCataloByTcid(theCourseCatalog t){
        if(thecoursecatalogservice.updatetheCourseCataloByTcid(t)>0){
            return t.getCoid();
        }
        return  null;
    }
}
