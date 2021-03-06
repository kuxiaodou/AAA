package com.aaa.infomation.controller;

import com.aaa.infomation.entity.course;
import com.aaa.infomation.entity.theCourseCatalog;
import com.aaa.infomation.service.courseService;
import com.aaa.infomation.service.theCourseCatalogInfoService;
import com.aaa.infomation.service.theCourseCatalogService;
import com.aaa.infomation.util.dateGeneral;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.util.*;

/**
 * 课程  Controller层
 */
@Controller
@RequestMapping("controllerCourse")
public class courseController extends dateGeneral {
    @Resource
    private courseService courseservice;
    @Resource
    private theCourseCatalogService thecoursecatalogservice;
    @Resource
    private theCourseCatalogInfoService thecoursecatalogInfoservice;
    private Integer coid;
    private String name;
    private String pres;

    /**
     * 查询精品课程
     *
     * @return
     */
    @RequestMapping("showByStateCourse")
    public @ResponseBody
    List<course> showByStateCourse(Model model) {
        List<course> listShowByStateCourse = courseservice.showByStateCourse(1);
        model.addAttribute("listShowByStateCourse", listShowByStateCourse);
        return listShowByStateCourse;
    }

    /**
     * 查询所有课程
     *
     * @return
     */
    @RequestMapping("showCourse")
    public @ResponseBody
    List<Map<String, Object>> showCourse(Integer pageSize) {
        if (pageSize == null) {
            pageSize = 1;
        }
        Page page = PageHelper.startPage(pageSize, 5);
        List<Map<String, Object>> listShowCourse = new ArrayList<Map<String, Object>>();
        Map<String, Object> map = new HashMap<String, Object>();
        Object num = 0;
        num = page.getTotal();
        listShowCourse = courseservice.showCourse(coid, name, pres);
        return listShowCourse;
    }

    @RequestMapping("showCourses")
    public @ResponseBody
    List<Map<String, Object>> showCourses() {
        List<Map<String, Object>> listShowCourse = new ArrayList<Map<String, Object>>();
        listShowCourse = courseservice.showCourse(coid, name, pres);

        return listShowCourse;
    }

    /**
     * 课程修改下架
     *
     * @param coid
     * @return
     */
    @RequestMapping("updateCourseShelves")
    public @ResponseBody
    boolean updateCourseShelves(Integer coid) {
        int flag = courseservice.updateCourseShelves(coid);
        System.out.print("下架");
        if (flag > 0) {
            return true;
        }
        return false;
    }

    /**
     * 课程修改在售
     *
     * @param coid
     * @return
     */
    @RequestMapping("updateCourseSale")
    public @ResponseBody
    boolean updateCourseSale(Integer coid) {
        int flag = courseservice.updateCourseSale(coid);
        System.out.print("在售");
        if (flag > 0) {
            return true;
        }
        return false;
    }

    /**
     * 此方法用来接收页面传来的值
     *
     * @param coids 接收页面传来的ID
     * @param names 接收页面传来的名称
     * @param press 接收页面传来的出版社
     * @return
     */
    @RequestMapping("aaa")
    public String aaa(Integer coids, String names, String press) {
        coid = coids;
        name = names;
        pres = press;
        System.out.print(names);
        return "redirect:/back/course-list.html";
    }

    /**
     * 添加课程
     */
    @RequestMapping("addCourse")
    public @ResponseBody
    Boolean addCourse(course c, @RequestParam("file") MultipartFile file, @RequestParam("files") MultipartFile files, HttpServletRequest request) {
        if (!file.isEmpty() && !files.isEmpty()) {
            try {
                String upl = request.getSession().getServletContext().getRealPath("/") + "images/";
                File dir = new File(upl);
                String name = file.getOriginalFilename();
                String uuids = UUID.randomUUID().toString() + name.substring(name.lastIndexOf("."));
                File ser = new File(upl + uuids);
                file.transferTo(ser);

                String upls = request.getSession().getServletContext().getRealPath("/") + "video/";
                File dirs = new File(upl);
                String names = file.getOriginalFilename();
                String uuidss = UUID.randomUUID().toString() + ".mp4";
                File sers = new File(upls + uuidss);
                files.transferTo(sers);

                Object obj = request.getSession().getAttribute("loginAdminAdid");
                c.setPicture("images/" + uuids);
                c.setVideo("video/" + uuidss);
                c.setAdid(Integer.parseInt(obj.toString()));
                c.setTheCumulativePurchase(0);
                c.setUsid(0);
                System.out.println(c);
                if (courseservice.addCourse(c) > 0) {
                    return true;
                } else {
                    return false;
                }

            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        } else {
            return false;
        }
    }

    /**
     * 修改课程 根据id查询
     *
     * @param coid
     * @return
     */
    @RequestMapping("showCourseByCoid")
    public @ResponseBody
    List<Map<String, Object>> showCourseByCoid(Integer coid) {
        List<Map<String, Object>> listshowCourseByCoid = courseservice.showCourseByCoid(coid);
        return listshowCourseByCoid;
    }

    /**
     * 更新课程
     * @param c
     * @param file
     * @param request
     * @return
     */
    @RequestMapping("updateCourseByCoid")
    public @ResponseBody
    boolean updateCourseByCoid(course c, @RequestParam("file") MultipartFile file, HttpServletRequest request) {
        if (!file.isEmpty()) {
            try {
                String upl = request.getSession().getServletContext().getRealPath("/") + "images/";
                File dir = new File(upl);
                String name = file.getOriginalFilename();
                String uuids = UUID.randomUUID().toString() + name.substring(name.lastIndexOf("."));
                File ser = new File(upl + uuids);
                file.transferTo(ser);
                c.setPicture("images/" + uuids);
                if (courseservice.updateCourseByCoid(c) > 0) {
                    return true;
                } else {
                    return false;
                }

            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        } else {
            return false;
        }
    }

    /**
     * 相关课程查询
     *
     * @param prid
     * @return
     */
    @RequestMapping("showCourseByPrid")
    public @ResponseBody
    List<Map<String, Object>> showCourseByPrid(Integer prid) {
        return courseservice.showCourseByPrid(prid);
    }

    /**
     * 删除课程所有信息
     * @param coid
     * @return
     */
    @RequestMapping("deleteCourseByCoid")
    public @ResponseBody
     boolean deleteCourseByCoid(Integer coid) {
        System.out.println(1);
        int CourseCatalogInfoNum = 0;
        List<theCourseCatalog> list = thecoursecatalogservice.selecttheCourseCatalogCoid(coid);
        for (int i = 0; i < list.size(); i++) {
            if (thecoursecatalogInfoservice.deletetheCourseCatalogInfoByTcid(list.get(i).getTcid()) > 0) {
                CourseCatalogInfoNum = 1;
            } else {
                CourseCatalogInfoNum = 0;
            }
        }
        int CourseCatalogNum = thecoursecatalogservice.deletetheCourseCatalogByCoid(coid);
        int CourseNum = courseservice.delteCourseByCoid(coid);
        if (CourseCatalogInfoNum > 0 && CourseCatalogNum > 0 && CourseNum > 0) {
            return true;
        } else {
            return false;
        }
    }
    /**
     * 根据老师 查询老师所教课程
     * @param adid
     * @return
     */
    @RequestMapping("showTeachersInfoByAdid")
    public @ResponseBody
    List<Map<String,Object>> showTeachersInfoByAdid(Integer adid){
        return courseservice.showTeachersInfoByAdid(adid);
    }
}
