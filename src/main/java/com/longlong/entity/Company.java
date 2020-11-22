package com.longlong.entity;

public class Company {
    private int userid;
    private String name;
    private String address;
    private String introduction;

    @Override
    public String toString() {
        return "Company{" +
                "userid=" + userid +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", introduction='" + introduction + '\'' +
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
