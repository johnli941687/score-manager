package com.clive.service;

import com.clive.model.*;
import com.clive.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;

@Service
public class AdminService {
    @Autowired
    private AdminRepository adminRepository;

    public List<UserData> getAllUserData() {
        return adminRepository.getAllUsers();
    }

    public void saveUser(UserData userData) {
        adminRepository.saveUser(userData);
    }

    public User getUserByUsername(String username) {
        return adminRepository.getUserByUsername(username);
    }

    public UserData getUserDataByUsername(String username) {
        return adminRepository.getUserDataByUsername(username);
    }

    public List<Department> getAllDepartments() {
        return adminRepository.getDepartments();
    }

    public List<String> getGenders() {
        return asList("Male", "Female");
    }

    public List<Role> getAllRoles() {
        return adminRepository.getAllRoles();
    }

    public UserData getUserDataById(String userId) {
        return adminRepository.getUserDataByUsername(userId);
    }

    public List<Major> getMajorsByDepartmentId(Integer departmentId) {
        return departmentId == null ? new ArrayList<>() : adminRepository.getMajorByDepartmentNumber(departmentId);
    }

    public void updateUserData(UserData userData, String userId) {
        adminRepository.updateUserData(userData, userId);
    }

    public void deleteUserByUserId(String userId) {
        adminRepository.deleteUserDataByUserId(userId);
    }
}
