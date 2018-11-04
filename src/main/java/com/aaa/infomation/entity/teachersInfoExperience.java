package com.aaa.infomation.entity;

import java.util.Date;

/**
 * 教师资料经验表 实体类
 */
public class teachersInfoExperience {
    private Integer ieid;
    private Date startExperience;
    private Date endExperience;
    private String varchar;
    private Date startResults;
    private Date endResults;
    private String eesultsContext;
    private Integer teid;
    private Date creationTime;
    private Date updateTime;

    public Integer getIeid() {
        return ieid;
    }

    public void setIeid(Integer ieid) {
        this.ieid = ieid;
    }

    public Date getStartExperience() {
        return startExperience;
    }

    public void setStartExperience(Date startExperience) {
        this.startExperience = startExperience;
    }

    public Date getEndExperience() {
        return endExperience;
    }

    public void setEndExperience(Date endExperience) {
        this.endExperience = endExperience;
    }

    public String getVarchar() {
        return varchar;
    }

    public void setVarchar(String varchar) {
        this.varchar = varchar;
    }

    public Date getStartResults() {
        return startResults;
    }

    public void setStartResults(Date startResults) {
        this.startResults = startResults;
    }

    public Date getEndResults() {
        return endResults;
    }

    public void setEndResults(Date endResults) {
        this.endResults = endResults;
    }

    public String getEesultsContext() {
        return eesultsContext;
    }

    public void setEesultsContext(String eesultsContext) {
        this.eesultsContext = eesultsContext;
    }

    public Integer getTeid() {
        return teid;
    }

    public void setTeid(Integer teid) {
        this.teid = teid;
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
        return "teachersInfoExperience{" +
                "ieid=" + ieid +
                ", startExperience=" + startExperience +
                ", endExperience=" + endExperience +
                ", varchar='" + varchar + '\'' +
                ", startResults=" + startResults +
                ", endResults=" + endResults +
                ", eesultsContext='" + eesultsContext + '\'' +
                ", teid=" + teid +
                ", creationTime=" + creationTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
