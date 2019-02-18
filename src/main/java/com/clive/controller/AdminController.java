package com.clive.controller;

import com.clive.model.Major;
import com.clive.model.User;
import com.clive.model.UserData;
import com.clive.service.AdminService;
import com.clive.support.AdminValidator;
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
    @Autowired
    private AdminValidator validator;

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
        appendOtherInfo(model, null);

        return "create-user";
    }

    @PostMapping("/user")
    public String createUser(@Valid @ModelAttribute UserData userData, BindingResult bindingResult, Model model) {
        validator.validateUserId(bindingResult, userData.getUserId());

        if (bindingResult.hasErrors()) {
            model.addAttribute("userData", userData);
            appendOtherInfo(model, userData.getDepartment() == null ? null : userData.getDepartment().getDepartmentNumber());

            return "create-user";
        }

        adminService.saveUser(userData);

        return "redirect:/admin/users";
    }

    @GetMapping("/user/{userId}")
    public String modifyUserForm(Model model, @PathVariable String userId) {
        UserData userData = adminService.getUserDataById(userId);
        model.addAttribute("userData", userData);
        appendOtherInfo(model, userData.getDepartment() == null ? null : userData.getDepartment().getDepartmentNumber());

        return "edit-user";
    }

    @PostMapping("/user/{userId}")
    public String modifyUser(Model model, @PathVariable String userId, @Valid @ModelAttribute UserData userData, BindingResult bindingResult) {
        validator.validateUserId(bindingResult, userData.getUserId());

        if (bindingResult.hasErrors()) {
            model.addAttribute("userData", userData);
            appendOtherInfo(model, userData.getDepartment() == null ? null : userData.getDepartment().getDepartmentNumber());

            return "edit-user";
        }

        adminService.updateUserData(userData, userId);

        return "redirect:/admin/users";
    }

    @GetMapping("/user/{userId}/delete")
    public String deleteUser(@PathVariable String userId) {
        adminService.deleteUserByUserId(userId);

        return "redirect:/admin/users";
    }

    @ResponseBody
    @GetMapping(value = "/department/{departmentId}/majors", produces = "application/json")
    public List<Major> getMajors(@PathVariable Integer departmentId) {
        return adminService.getMajorsByDepartmentId(departmentId);
    }

    private void appendOtherInfo(Model model, Integer departmemtId) {
        model.addAttribute("genders", adminService.getGenders());
        model.addAttribute("departments", adminService.getAllDepartments());
        model.addAttribute("majors", adminService.getMajorsByDepartmentId(departmemtId));
        model.addAttribute("roles", adminService.getAllRoles());
    }
}
