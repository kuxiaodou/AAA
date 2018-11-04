package com.aaa.infomation.entity;

import java.util.Date;

/**
 * 课程评论 实体类
 */
public class courseComment {
    private Integer ceid;
    private String star;
    private String context;
    private Integer coid;
    private Integer usid;
    private Date creationTime;

    public Integer getCeid() {
        return ceid;
    }

    public void setCeid(Integer ceid) {
        this.ceid = ceid;
    }

    public String getStar() {
        return star;
    }

    public void setStar(String star) {
        this.star = star;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public Integer getCoid() {
        return coid;
    }

    public void setCoid(Integer coid) {
        this.coid = coid;
    }

    public Integer getUsid() {
        return usid;
    }

    public void setUsid(Integer usid) {
        this.usid = usid;
    }

    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }

    @Override
    public String toString() {
        return "courseComment{" +
                "ceid=" + ceid +
                ", star='" + star + '\'' +
                ", context='" + context + '\'' +
                ", coid=" + coid +
                ", usid=" + usid +
                ", creationTime=" + creationTime +
                '}';
    }
}
