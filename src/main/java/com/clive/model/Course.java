package com.clive.model;

import javax.validation.constraints.*;

public class Course {
    private Integer id;
    @NotBlank
    private String name;
    @NotNull
    @Digits(integer = 1, fraction = 0)
    @Min(1)
    @Max(4)
    private Integer credit;
    @NotNull
    @Digits(integer = 2, fraction = 0)
    private Integer hours;
    private UserData teacher;
    private Semester semester;

    public Course() {
    }

    public Course(Integer id, String name, Integer credit, Integer hours, UserData teacher, Semester semester) {
        this.id = id;
        this.name = name;
        this.credit = credit;
        this.hours = hours;
        this.teacher = teacher;
        this.semester = semester;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCredit() {
        return credit;
    }

    public void setCredit(Integer credit) {
        this.credit = credit;
    }

    public Integer getHours() {
        return hours;
    }

    public void setHours(Integer hours) {
        this.hours = hours;
    }

    public UserData getTeacher() {
        return teacher;
    }

    public void setTeacher(UserData teacher) {
        this.teacher = teacher;
    }

    public Semester getSemester() {
        return semester;
    }

    public void setSemester(Semester semester) {
        this.semester = semester;
    }
}
