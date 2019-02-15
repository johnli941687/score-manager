package com.clive.model;

public class Major {
    private Integer majorNumber;
    private String majorName;

    public Major() {
    }

    public Major(Integer majorNumber, String majorName) {
        this.majorNumber = majorNumber;
        this.majorName = majorName;
    }

    public Integer getMajorNumber() {
        return majorNumber;
    }

    public void setMajorNumber(Integer majorNumber) {
        this.majorNumber = majorNumber;
    }

    public String getMajorName() {
        return majorName;
    }

    public void setMajorName(String majorName) {
        this.majorName = majorName;
    }
}
