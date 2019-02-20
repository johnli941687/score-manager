package com.clive.service;

import com.clive.model.User;
import com.clive.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private AdminRepository adminRepository;

    public User getUserByUsername(String username) {
        return adminRepository.getUserByUserId(username);
    }

    public User getCurrentUser() {
        if (SecurityContextHolder.getContext().getAuthentication() == null) {
            return null;
        }

        return (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}
