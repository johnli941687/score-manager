package com.clive.model;

import java.time.LocalDate;

import static java.time.format.DateTimeFormatter.ofPattern;

public class Semester {
    private Integer id;
    private String name;
    private LocalDate start;
    private LocalDate end;

    public Semester() {
    }

    public Semester(Integer id, String name, LocalDate start, LocalDate end) {
        this.id = id;
        this.name = name;
        this.start = start;
        this.end = end;
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

    public LocalDate getStart() {
        return start;
    }

    public void setStart(LocalDate start) {
        this.start = start;
    }

    public LocalDate getEnd() {
        return end;
    }

    public void setEnd(LocalDate end) {
        this.end = end;
    }

    public String getFormattedStartDate() {
        return start == null ? null : start.format(ofPattern("MM/dd/yyyy"));
    }

    public String getFormattedEndDate(){
        return end == null ? null : end.format(ofPattern("MM/dd/yyyy"));
    }
}
