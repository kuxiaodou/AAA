package com.aaa.infomation.entity;

import java.util.Date;

public class catalogue {
    private Integer caid;
    private String title;
    private String explain;
    private Integer usid;
    private Integer adid;
    private Integer viewcont;
    private Integer collect;
    private Integer type;
    private Integer types;
    private Integer major;
    private Double money;
    private Date creationTime;
    private Date updateTime;

    public Integer getCaid() {
        return caid;
    }

    public void setCaid(Integer caid) {
        this.caid = caid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getExplain() {
        return explain;
    }

    public void setExplain(String explain) {
        this.explain = explain;
    }

    public Integer getUsid() {
        return usid;
    }

    public void setUsid(Integer usid) {
        this.usid = usid;
    }

    public Integer getAdid() {
        return adid;
    }

    public void setAdid(Integer adid) {
        this.adid = adid;
    }

    public Integer getViewcont() {
        return viewcont;
    }

    public void setViewcont(Integer viewcont) {
        this.viewcont = viewcont;
    }

    public Integer getCollect() {
        return collect;
    }

    public void setCollect(Integer collect) {
        this.collect = collect;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getTypes() {
        return types;
    }

    public void setTypes(Integer types) {
        this.types = types;
    }

    public Integer getMajor() {
        return major;
    }

    public void setMajor(Integer major) {
        this.major = major;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
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
        return "catalogue{" +
                "caid=" + caid +
                ", title='" + title + '\'' +
                ", explain='" + explain + '\'' +
                ", usid=" + usid +
                ", adid=" + adid +
                ", viewcont=" + viewcont +
                ", collect=" + collect +
                ", type=" + type +
                ", types=" + types +
                ", major=" + major +
                ", money=" + money +
                ", creationTime=" + creationTime +
                ", updateTime=" + updateTime +
                '}';
    }
}