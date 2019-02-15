package com.clive.controller;

import com.clive.model.Major;
import com.clive.model.User;
import com.clive.model.UserData;
import com.clive.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @GetMapping("/users")
    public String getAllUsers(Model model) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        model.addAttribute("user", user);
        model.addAttribute("userDatas", adminService.getAllUserData());

        return "users";
    }

    @GetMapping("/user")
    public String showCreateUserForm(Model model) {
        model.addAttribute("userData", new UserData());
        appendOtherInfo(model);

        return "create-user";
    }

    @PostMapping("/user")
    public String createUser(Model model, @Valid @ModelAttribute UserData userData, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("userData", userData);
            appendOtherInfo(model);

            return "create-user";
        }

        adminService.saveUser(userData);

        return "redirect:/admin/users";
    }

    @GetMapping("/user/{userId}")
    public String modifyUserForm(Model model, @PathVariable String userId) {
        model.addAttribute("userData", adminService.getUserDataById(userId));
        appendOtherInfo(model);

        return "edit-user";
    }

    @ResponseBody
    @GetMapping(value = "/department/{departmentId}/majors", produces = "application/json")
    public List<Major> getMajors(@PathVariable Integer departmentId) {
        return adminService.getMajorsByDepartmentId(departmentId);
    }

    private void appendOtherInfo(Model model) {
        model.addAttribute("genders", adminService.getGenders());
        model.addAttribute("departments", adminService.getAllDepartments());
        model.addAttribute("majors", new ArrayList<Major>());
        model.addAttribute("roles", adminService.getAllRoles());
    }
}
