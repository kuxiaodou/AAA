package com.aaa.infomation.entity;

import java.util.Date;

/*
* 文档表
* */
public class onlineDocumentation {
    private Integer onid;
    private String title;
    private Integer caid;
    private String context;
    private Integer viewconts;
    private Date creationTime;
    private Date updateTime;

    public Integer getOnid() {
        return onid;
    }

    public void setOnid(Integer onid) {
        this.onid = onid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getCaid() {
        return caid;
    }

    public void setCaid(Integer caid) {
        this.caid = caid;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public Integer getViewconts() {
        return viewconts;
    }

    public void setViewconts(Integer viewconts) {
        this.viewconts = viewconts;
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
        return "onlineDocumentation{" +
                "onid=" + onid +
                ", title='" + title + '\'' +
                ", caid=" + caid +
                ", context='" + context + '\'' +
                ", viewconts=" + viewconts +
                ", creationTime=" + creationTime +
                ", updateTime=" + updateTime +
                '}';
    }
}