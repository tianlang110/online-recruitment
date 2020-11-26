package com.longlong.entity;

public class BigRecruit {
    private String seekername;
    private String type;
    private String companyname;
    private String time;
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "BigRecruit{" +
                "seekername='" + seekername + '\'' +
                ", type='" + type + '\'' +
                ", companyname='" + companyname + '\'' +
                ", time='" + time + '\'' +
                '}';
    }

    public String getSeekername() {
        return seekername;
    }

    public void setSeekername(String seekername) {
        this.seekername = seekername;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCompanyname() {
        return companyname;
    }

    public void setCompanyname(String companyname) {
        this.companyname = companyname;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
