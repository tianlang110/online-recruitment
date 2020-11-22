package com.longlong.entity;

public class Post {
    private int companyid;
    private int postid;
    private String name;
    private String type;
    private String salary;
    private String requirement;
    private String introduction;

    @Override
    public String toString() {
        return "Post{" +
                "companyid=" + companyid +
                ", postid=" + postid +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", salary='" + salary + '\'' +
                ", requirement='" + requirement + '\'' +
                ", introduction='" + introduction + '\'' +
                '}';
    }

    public int getCompanyid() {
        return companyid;
    }

    public void setCompanyid(int companyid) {
        this.companyid = companyid;
    }

    public int getPostid() {
        return postid;
    }

    public void setPostid(int postid) {
        this.postid = postid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getRequirement() {
        return requirement;
    }

    public void setRequirement(String requirement) {
        this.requirement = requirement;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }
}
