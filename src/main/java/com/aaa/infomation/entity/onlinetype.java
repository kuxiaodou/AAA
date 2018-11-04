package com.aaa.infomation.entity;

/**
 * 文档分类表
 */
public class onlinetype {
    private Integer odid;
    private String  type;

    public Integer getOdid() {
        return odid;
    }

    public void setOdid(Integer odid) {
        this.odid = odid;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "onlinetype{" +
                "odid=" + odid +
                ", type='" + type + '\'' +
                '}';
    }
}