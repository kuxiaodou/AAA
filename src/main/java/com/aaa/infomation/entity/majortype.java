package com.aaa.infomation.entity;

/*
*专业分类表
* */
public class majortype {
    private Integer maid;
    private String type;
    private Integer odid;

    public Integer getMaid() {
        return maid;
    }

    public void setMaid(Integer maid) {
        this.maid = maid;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getOdid() {
        return odid;
    }

    public void setOdid(Integer odid) {
        this.odid = odid;
    }

    @Override
    public String toString() {
        return "majortype{" +
                "maid=" + maid +
                ", type='" + type + '\'' +
                ", odid=" + odid +
                '}';
    }
}