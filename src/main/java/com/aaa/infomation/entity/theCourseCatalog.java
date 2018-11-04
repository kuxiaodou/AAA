package com.aaa.infomation.entity;

import java.util.Date;

/**
 * 课程目录类
 */
public class theCourseCatalog {
    private Integer tcid;
    private String name;
    private Integer coid;
    private Date creationTime;
    private Date updateTime;

    public Integer getTcid() {
        return tcid;
    }

    public void setTcid(Integer tcid) {
        this.tcid = tcid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCoid() {
        return coid;
    }

    public void setCoid(Integer coid) {
        this.coid = coid;
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

    @Override
    public String toString() {
        return "theCourseCatalog{" +
                "tcid=" + tcid +
                ", name='" + name + '\'' +
                ", coid=" + coid +
                ", creationTime=" + creationTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
