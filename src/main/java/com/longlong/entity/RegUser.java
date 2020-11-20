package com.longlong.entity;

public class RegUser {
    private String username;
    private String password;
    private int usertype;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getUsertype() {
        return usertype;
    }

    public void setUsertype(int usertype) {
        this.usertype = usertype;
    }

    @Override
    public String toString() {
        return "RegUser{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", usertype=" + usertype +
                '}';
    }
}
