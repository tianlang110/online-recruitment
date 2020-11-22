package com.longlong.entity;

public class Admin {
    private int userid;
    private String name;

    @Override
    public String toString() {
        return "Admin{" +
                "userid=" + userid +
                ", name='" + name + '\'' +
                '}';
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
