package com.borris.pojo;

public class User {
    private String id;

    private String name;

    private String password;

    private Double grade;

    private Integer disNum;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Double getGrade() {
        return grade;
    }

    public void setGrade(Double grade) {
        this.grade = grade;
    }

    public Integer getDisNum() {
        return disNum;
    }

    public void setDisNum(Integer disNum) {
        this.disNum = disNum;
    }
}