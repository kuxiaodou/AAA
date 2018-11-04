package com.aaa.infomation.entity;

import java.util.Date;

/**
 * 课程一级分类表
 */
public class thePrimaryClassification {
    private Integer prid;
    private String name;
    private Date creationTime;
    private Date updateTime;

    public Integer getPrid() {
        return prid;
    }

    public void setPrid(Integer prid) {
        this.prid = prid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        return "thePrimaryClassification{" +
                "prid=" + prid +
                ", name=" + name +
                ", creationTime=" + creationTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
