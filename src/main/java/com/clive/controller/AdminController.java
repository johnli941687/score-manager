package com.clive.controller;

import com.clive.model.User;
import com.clive.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @GetMapping("/users")
    public String getAllUsers(Model model) {
        model.addAttribute("users", adminService.getAllUsers());

        return "users";
    }

    @GetMapping("/user")
    public String showCreateUserForm(Model model) {
        model.addAttribute("user", new User());

        return "user";
    }
}
