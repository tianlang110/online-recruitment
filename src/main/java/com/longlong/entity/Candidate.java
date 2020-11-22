package com.longlong.entity;

import java.util.Date;

public class Candidate {
    private int seekerid;
    private int postid;
    private int id;
    private Date time;

    @Override
    public String toString() {
        return "Candidate{" +
                "seekerid=" + seekerid +
                ", postid=" + postid +
                ", id=" + id +
                ", time=" + time +
                '}';
    }

    public int getSeekerid() {
        return seekerid;
    }

    public void setSeekerid(int seekerid) {
        this.seekerid = seekerid;
    }

    public int getPostid() {
        return postid;
    }

    public void setPostid(int postid) {
        this.postid = postid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
