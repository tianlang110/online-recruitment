package com.longlong.entity;

import java.util.Date;

public class JobFair {
    private int id;
    private String name;
    private Date time;
    private String address;
    private String introduction;

    @Override
    public String toString() {
        return "JobFair{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", time=" + time +
                ", address='" + address + '\'' +
                ", introduction='" + introduction + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }
}
