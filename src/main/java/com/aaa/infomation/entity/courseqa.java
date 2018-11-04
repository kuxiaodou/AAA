package com.aaa.infomation.entity;

import java.util.Date;

/**
 * 课程问答 实体类
 */
public class courseqa {
    private Integer qaid;
    private Integer coid;
    private Object usid;
    private String title;
    private String context;
    private Date creationTime;

    public Integer getQaid() {
        return qaid;
    }

    public void setQaid(Integer qaid) {
        this.qaid = qaid;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }

    @Override
    public String toString() {
        return "courseqa{" +
                "qaid=" + qaid +
                ", coid=" + coid +
                ", usid=" + usid +
                ", title='" + title + '\'' +
                ", context='" + context + '\'' +
                ", creationTime=" + creationTime +
                '}';
    }
}
