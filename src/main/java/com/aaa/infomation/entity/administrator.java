package com.aaa.infomation.entity;

import java.util.Date;

/**
 * 管理员 实体类
 */
public class administrator {
   private Integer adid;
    private String nam;
    private String password	;
    private String  headPortrait;
    private Integer position;
    private Integer state;
    private Date creationTime;
    private Date  updateTime;

    public Integer getAdid() {
        return adid;
    }

    public void setAdid(Integer adid) {
        this.adid = adid;
    }

    public String getNam() {
        return nam;
    }

    public void setNam(String nam) {
        this.nam = nam;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getHeadPortrait() {
        return headPortrait;
    }

    public void setHeadPortrait(String headPortrait) {
        this.headPortrait = headPortrait;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
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

    @Override
    public String toString() {
        return "administrator{" +
                "adid=" + adid +
                ", nam='" + nam + '\'' +
                ", password='" + password + '\'' +
                ", headPortrait='" + headPortrait + '\'' +
                ", position=" + position +
                ", state=" + state +
                ", creationTime=" + creationTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
