package com.aaa.infomation.entity;

import java.util.Date;

/**
 * 课程类
 */

public class course {
    private Integer coid;
    private String name;
    private String courseFee;
    private Integer theCumulativePurchase;
    private String press;
    private String courseOverview;
    private String picture;
    private String video;
    private Integer usid;
    private Integer state;
    private Date creationTime;
    private Date updateTime;
    private Integer prid;
    private Integer adid;

    public Integer getCoid() {
        return coid;
    }

    public void setCoid(Integer coid) {
        this.coid = coid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCourseFee() {
        return courseFee;
    }

    public void setCourseFee(String courseFee) {
        this.courseFee = courseFee;
    }

    public Integer getTheCumulativePurchase() {
        return theCumulativePurchase;
    }

    public void setTheCumulativePurchase(Integer theCumulativePurchase) {
        this.theCumulativePurchase = theCumulativePurchase;
    }

    public String getPress() {
        return press;
    }

    public void setPress(String press) {
        this.press = press;
    }

    public String getCourseOverview() {
        return courseOverview;
    }

    public void setCourseOverview(String courseOverview) {
        this.courseOverview = courseOverview;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public Integer getUsid() {
        return usid;
    }

    public void setUsid(Integer usid) {
        this.usid = usid;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getPrid() {
        return prid;
    }

    public void setPrid(Integer prid) {
        this.prid = prid;
    }

    public Integer getAdid() {
        return adid;
    }

    public void setAdid(Integer adid) {
        this.adid = adid;
    }

    @Override
    public String toString() {
        return "course{" +
                "coid=" + coid +
                ", name='" + name + '\'' +
                ", courseFee='" + courseFee + '\'' +
                ", theCumulativePurchase='" + theCumulativePurchase + '\'' +
                ", press='" + press + '\'' +
                ", courseOverview='" + courseOverview + '\'' +
                ", picture='" + picture + '\'' +
                ", video='" + video + '\'' +
                ", usid=" + usid +
                ", state=" + state +
                ", creationTime=" + creationTime +
                ", updateTime=" + updateTime +
                ", prid=" + prid +
                ", adid=" + adid +
                '}';
    }
}
