package com.longlong.entity;

import java.util.Date;

public class BigCandidate {
    private String postname;
    private String posttype;
    private String type;
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "BigCandidate{" +
                "postname='" + postname + '\'' +
                ", posttype='" + posttype + '\'' +
                ", Seekername='" + Seekername + '\'' +
                ", time=" + time +
                '}';
    }

    public String getPostname() {
        return postname;
    }

    public void setPostname(String postname) {
        this.postname = postname;
    }

    public String getPosttype() {
        return posttype;
    }

    public void setPosttype(String posttype) {
        this.posttype = posttype;
    }

    public String getSeekername() {
        return Seekername;
    }

    public void setSeekername(String seekername) {
        Seekername = seekername;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    private String Seekername;
    private int seekerid;

    public int getSeekerid() {
        return seekerid;
    }

    public void setSeekerid(int seekerid) {
        this.seekerid = seekerid;
    }

    private String time;
}
