package com.aaa.infomation.entity;

import java.util.Date;

public class iOfCourse {
    private Integer ioid;
    private Integer coid;
    private Object usid;
    private String theProgressof;
    private Date creationTime;
    private Date updateTime	;

    public Integer getIoid() {
        return ioid;
    }

    public void setIoid(Integer ioid) {
        this.ioid = ioid;
    }

    public Integer getCoid() {
        return coid;
    }

    public void setCoid(Integer coid) {
        this.coid = coid;
    }

    public Object getUsid() {
        return usid;
    }

    public void setUsid(Object usid) {
        this.usid = usid;
    }

    public String getTheProgressof() {
        return theProgressof;
    }

    public void setTheProgressof(String theProgressof) {
        this.theProgressof = theProgressof;
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
        return "iOfCourse{" +
                "ioid=" + ioid +
                ", coid=" + coid +
                ", usid=" + usid +
                ", theProgressof='" + theProgressof + '\'' +
                ", creationTime=" + creationTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
