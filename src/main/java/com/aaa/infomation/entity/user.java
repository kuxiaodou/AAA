package com.aaa.infomation.entity;

import java.util.Date;

/**
 * 用户类
 */
public class user {
    private Integer usid;
    private String name;
    private String phone;
    private String email;
    private String password;
    private Integer position;
    private Integer state;
    private String headPortrait;
    private String theSignature;
    private Date creationTime;
    private Date updateTime;
    private Integer adid;
    private String aname;//操作用户
    public Integer getUsid() {
        return usid;
    }

    public void setUsid(Integer usid) {
        this.usid = usid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getHeadPortrait() {
        return headPortrait;
    }

    public void setHeadPortrait(String headPortrait) {
        this.headPortrait = headPortrait;
    }

    public String getTheSignature() {
        return theSignature;
    }

    public void setTheSignature(String theSignature) {
        this.theSignature = theSignature;
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

    public Integer getAdid() {
        return adid;
    }

    public void setAdid(Integer adid) {
        this.adid = adid;
    }

    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname;
    }

    @Override
    public String toString() {
        return "user{" +
                "usid=" + usid +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", position=" + position +
                ", state=" + state +
                ", headPortrait='" + headPortrait + '\'' +
                ", theSignature='" + theSignature + '\'' +
                ", creationTime=" + creationTime +
                ", updateTime=" + updateTime +
                ", adid=" + adid +
                ", aname='" + aname + '\'' +
                '}';
    }
}
