package com.clive.controller;

import com.clive.model.User;
import com.clive.service.AdminService;
import com.clive.support.Formatters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.time.LocalDate;

import static java.time.LocalDate.now;

@Controller
@RequestMapping
@SessionAttributes({"user"})
public class HomeController {
    @Autowired
    private AdminService adminService;

    @GetMapping("/home")
    public String showHome(Model model) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        model.addAttribute("userData", adminService.getUserDataByUsername(user.getUsername()));
        model.addAttribute("formattedCurrentDate", Formatters.getFormattedLocalDate(now()));

        return "home";
    }
}
