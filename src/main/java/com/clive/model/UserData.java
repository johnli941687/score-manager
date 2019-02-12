package com.clive.model;

public class UserData {
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

    public UserData() {
    }

    public UserData(Integer id, String userId, String username, String password, Integer age, String gender, String department, String major, String phone, String email, String role) {
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

    public void setId(Integer id) {
        this.id = id;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
