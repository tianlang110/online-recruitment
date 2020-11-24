package com.longlong.entity;

import java.util.Date;

public class Recruit {
    private int id;
    private int companyid;
    private int seekerid;
    private Date time;
    private String state;

    @Override
    public String toString() {
        return "Recruit{" +
                "id=" + id +
                ", companyid=" + companyid +
                ", seekerid=" + seekerid +
                ", time=" + time +
                ", state='" + state + '\'' +
                '}';
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCompanyid() {
        return companyid;
    }

    public void setCompanyid(int companyid) {
        this.companyid = companyid;
    }

    public int getSeekerid() {
        return seekerid;
    }

    public void setSeekerid(int seekerid) {
        this.seekerid = seekerid;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
