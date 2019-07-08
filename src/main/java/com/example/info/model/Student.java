package com.example.info.model;

public class Student {
    private Integer stno;

    private String stname;

    public Integer getStno() {
        return stno;
    }

    public void setStno(Integer stno) {
        this.stno = stno;
    }

    public String getStname() {
        return stname;
    }

    public void setStname(String stname) {
        this.stname = stname == null ? null : stname.trim();
    }
}