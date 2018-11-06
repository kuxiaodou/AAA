package com.aaa.infomation.entity;

import java.util.Date;

/**
 * 教师资料表 实体类
 */
public class teachersInfo {
    private Integer teid;
    private String name;
    private String idCardPic;
    private String idCardNo;
    private String certificatePic;
    private String certificateName;
    private String headPortrait;
    private String qq;
    private String email;
    private String introduction;
    private Integer usid;
    private Integer adid;
    private Date creationTime;
    private Date updateTime;
    private String style;

    public Integer getTeid() {
        return teid;
    }

    public void setTeid(Integer teid) {
        this.teid = teid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdCardPic() {
        return idCardPic;
    }

    public void setIdCardPic(String idCardPic) {
        this.idCardPic = idCardPic;
    }

    public String getIdCardNo() {
        return idCardNo;
    }

    public void setIdCardNo(String idCardNo) {
        this.idCardNo = idCardNo;
    }

    public String getCertificatePic() {
        return certificatePic;
    }

    public void setCertificatePic(String certificatePic) {
        this.certificatePic = certificatePic;
    }

    public String getCertificateName() {
        return certificateName;
    }

    public void setCertificateName(String certificateName) {
        this.certificateName = certificateName;
    }

    public String getHeadPortrait() {
        return headPortrait;
    }

    public void setHeadPortrait(String headPortrait) {
        this.headPortrait = headPortrait;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
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

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    @Override
    public String toString() {
        return "teachersInfo{" +
                "teid=" + teid +
                ", name='" + name + '\'' +
                ", idCardPic='" + idCardPic + '\'' +
                ", idCardNo='" + idCardNo + '\'' +
                ", certificatePic='" + certificatePic + '\'' +
                ", certificateName='" + certificateName + '\'' +
                ", headPortrait='" + headPortrait + '\'' +
                ", qq='" + qq + '\'' +
                ", email='" + email + '\'' +
                ", introduction='" + introduction + '\'' +
                ", usid=" + usid +
                ", adid=" + adid +
                ", creationTime=" + creationTime +
                ", updateTime=" + updateTime +
                ", style='" + style + '\'' +
                '}';
    }
}
