package com.aaa.infomation.controller;

import com.aaa.infomation.entity.theCourseCatalogInfo;
import com.aaa.infomation.service.theCourseCatalogInfoService;
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
 * 课程目录详细 Controller层
 */
@Controller
@RequestMapping("controllerTheCourseCatalogInfo")
public class theCourseCatalogInfoController {
    @Resource
    private theCourseCatalogInfoService thecoursecataloginfoservice;

    /**
     * 查询课程目录详细
     */
    @RequestMapping("showAlltheCourseCatalogInfo")
    public @ResponseBody
    List<Map<String, Object>> showAlltheCourseCatalogInfo() {
        List<Map<String, Object>> listshowAlltheCourseCatalogInfo = thecoursecataloginfoservice.showAlltheCourseCatalogInfo();
        System.out.println(listshowAlltheCourseCatalogInfo.size());
        return listshowAlltheCourseCatalogInfo;
    }

    /**
     * 查询课程目录详细
     * @param tcid
     * @return
     */
    @RequestMapping("showAlltheCourseCatalogInfofont")
    public @ResponseBody
    List<Map<String, Object>> showAlltheCourseCatalogInfofont(Integer tcid) {
        if(tcid!=null){
            List<Map<String, Object>> listshowAlltheCourseCatalogInfo = thecoursecataloginfoservice.showAlltheCourseCatalogInfofont(tcid);
            return listshowAlltheCourseCatalogInfo;
        }else{
            return null;
        }

    }
    /**
     * 根据tnid主键 删除课程目录详细
     *
     * @param tnid
     * @param coid
     * @return
     */
    @RequestMapping("deleteCourseCatalogInfoByTcid")
    public @ResponseBody
    Integer deleteCourseCatalogInfoByTcid(Integer tnid, Integer coid) {
        if (thecoursecataloginfoservice.deleteCourseCatalogInfoByTnid(tnid) > 0) {
                return coid;
        }
        return null;
    }

    /**
     * 根据tnid主键 查询课程目录详细
     * @param tnid
     * @return
     */
    @RequestMapping("showThecoursecataloginfoByTnid")
    public @ResponseBody
    List<Map<String,Object>> showThecoursecataloginfoByTnid(Integer tnid){
        return thecoursecataloginfoservice.showThecoursecataloginfoByTnid(tnid);
    }

    /**
     * 修改课程目录详细
     * @param file
     * @param request
     * @param t
     * @return
     */
    @RequestMapping("updateThecoursecataloginfoByTnid")
    public @ResponseBody
    Integer updateThecoursecataloginfoByTnid(@RequestParam("file") MultipartFile file, HttpServletRequest request, theCourseCatalogInfo t,Integer coid) {
        theCourseCatalogInfo tc = new theCourseCatalogInfo();
            try {
                String upl = request.getSession().getServletContext().getRealPath("/") + "video/";
                File dir = new File(upl);
                String name = file.getOriginalFilename();
                String uuid = UUID.randomUUID().toString() + ".mp4";
                tc.setTvideo("video/" + uuid);
                tc.setTname(t.getTname());
                tc.setTnid(t.getTnid());
                tc.setLength(t.getLength());
                File ser = new File(upl + uuid);
                file.transferTo(ser);

            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
            if (thecoursecataloginfoservice.updateThecoursecataloginfoByTnid(tc) > 0) {
                System.out.println(tc);
                return coid;
            } else {
                return coid;
            }
    }
    /**
     * 查询某一门课程的所有课时
     * @param coid
     * @return
     */
    @RequestMapping("showThecoursecataloginfoByCoid")
    public @ResponseBody
    List<Map<String,Object>> showThecoursecataloginfoByCoid(Integer coid){
        return thecoursecataloginfoservice.showThecoursecataloginfoByCoid(coid);
    }

}
