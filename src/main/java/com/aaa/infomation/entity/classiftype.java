package com.aaa.infomation.entity;

/*
* 文档类型表
* */
public class classiftype {
    private Integer clid;
    private String type;
    private Integer odid;

    public Integer getClid() {
        return clid;
    }

    public void setClid(Integer clid) {
        this.clid = clid;
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
        return "classiftype{" +
                "clid=" + clid +
                ", type='" + type + '\'' +
                ", odid=" + odid +
                '}';
    }
}