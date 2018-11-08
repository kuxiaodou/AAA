package com.aaa.infomation.entity;

/**
 * 我的课程进度表 实体类
 */
public class iOfCourseSchedule {
    private Integer isid;
    private Integer usid;
    private Integer tnid;
    private Integer state;

    public Integer getIsid() {
        return isid;
    }

    public void setIsid(Integer isid) {
        this.isid = isid;
    }

    public Integer getUsid() {
        return usid;
    }

    public void setUsid(Integer usid) {
        this.usid = usid;
    }

    public Integer getTnid() {
        return tnid;
    }

    public void setTnid(Integer tnid) {
        this.tnid = tnid;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "iOfCourseSchedule{" +
                "isid=" + isid +
                ", usid=" + usid +
                ", tnid=" + tnid +
                ", state=" + state +
                '}';
    }
}
