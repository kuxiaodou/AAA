package com.aaa.infomation.entity;

public class collectionofdocuments {
    private Integer doid;
    private Integer caid;
    private Integer usid;

    public Integer getDoid() {
        return doid;
    }

    public void setDoid(Integer doid) {
        this.doid = doid;
    }

    public Integer getCaid() {
        return caid;
    }

    public void setCaid(Integer caid) {
        this.caid = caid;
    }

    public Integer getUsid() {
        return usid;
    }

    public void setUsid(Integer usid) {
        this.usid = usid;
    }

    @Override
    public String toString() {
        return "collectionofdocuments{" +
                "doid=" + doid +
                ", caid=" + caid +
                ", usid=" + usid +
                '}';
    }
}
