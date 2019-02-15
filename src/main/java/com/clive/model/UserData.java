package com.clive.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

public class UserData {
    @NotEmpty
    private String userId;
    @NotEmpty
    private String username;
    private String password;
    @NotNull
    private Integer age;
    private String gender;
    private Department department;
    private Major major;
    @NotEmpty
    private String phone;
    @NotEmpty
    private String email;
    private Role role;
    private LocalDateTime createdOn;
    private LocalDateTime modifiedOn;

    public UserData() {
    }

    public UserData(String userId, String username, String password, Integer age, String gender, Department department, Major major, String phone, String email, Role role, LocalDateTime createdOn, LocalDateTime modifiedOn) {
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
        this.createdOn = createdOn;
        this.modifiedOn = modifiedOn;
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

    public Department getDepartment() {
        return department;
    }

    public Major getMajor() {
        return major;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public Role getRole() {
        return role;
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

    public void setDepartment(Department department) {
        this.department = department;
    }

    public void setMajor(Major major) {
        this.major = major;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public LocalDateTime getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(LocalDateTime createdOn) {
        this.createdOn = createdOn;
    }

    public LocalDateTime getModifiedOn() {
        return modifiedOn;
    }

    public void setModifiedOn(LocalDateTime modifiedOn) {
        this.modifiedOn = modifiedOn;
    }
}
