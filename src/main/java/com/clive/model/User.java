package com.clive.model;

public class User {
    private Integer id;
    private String userId;
    private String username;
    private String password;
    private Integer age;
    private String gender;
    private String department;
    private String major;
    private String phone;
    private String email;
    private String role;

    public User() {
    }

    public User(Integer id, String userId, String username, String password, Integer age, String gender, String department, String major, String phone, String email, String role) {
        this.id = id;
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.age = age;
        this.gender = gender;
        this.department = department;
        this.major = major;
        this.phone = phone;
        this.email = email;
        this.role = role;
    }

    public Integer getId() {
        return id;
    }

    public String getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Integer getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public String getDepartment() {
        return department;
    }

    public String getMajor() {
        return major;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getRole() {
        return role;
    }
}
