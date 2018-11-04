package com.aaa.infomation.entity;

import java.util.Date;

/**
 * 课程目录详细实体类
 */
public class theCourseCatalogInfo {
    private Integer tnid;
    private String tname;
    private String tvideo;
    private Integer tcid;
    private Date creationTime;
    private Date updateTime;
    private String state;
    private String length;


    public Integer getTnid() {
        return tnid;
    }

    public void setTnid(Integer tnid) {
        this.tnid = tnid;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public String getTvideo() {
        return tvideo;
    }

    public void setTvideo(String tvideo) {
        this.tvideo = tvideo;
    }

    public Integer getTcid() {
        return tcid;
    }

    public void setTcid(Integer tcid) {
        this.tcid = tcid;
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

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    @Override
    public String toString() {
        return "theCourseCatalogInfo{" +
                "tnid=" + tnid +
                ", tname='" + tname + '\'' +
                ", tvideo='" + tvideo + '\'' +
                ", tcid=" + tcid +
                ", creationTime=" + creationTime +
                ", updateTime=" + updateTime +
                ", state='" + state + '\'' +
                ", length='" + length + '\'' +
                '}';
    }
}
