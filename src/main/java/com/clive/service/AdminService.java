package com.clive.service;

import com.clive.model.UserData;
import com.clive.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {
    @Autowired
    private AdminRepository adminRepository;

    public List<UserData> getAllUsers() {
        return adminRepository.getAllUsers();
    }

    public void saveUser(UserData userData) {
//        Integer roleId = adminRepository.getRoleIdByRoleName(userData.getRole());

        adminRepository.saveUser(userData);
    }
}
