package com.clive.controller;

import com.clive.model.Course;
import com.clive.service.StudentService;
import com.clive.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/student")
class StudentController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public String registerCoursePage(Model model) {
        List<Course> allCourses = studentService.getAllCourses(userService.getCurrentUser().getUsername());

        model.addAttribute("courses", allCourses);

        return "student/register";
    }

    @GetMapping("/register/course/{courseId}")
    public String registerCourse(@PathVariable Integer courseId) {
        studentService.registerCourse(userService.getCurrentUser().getUsername(), courseId);

        return "redirect:/student/register";
    }

    @GetMapping("/course/{courseId}")
    public String showCourseDetail(Model model, @PathVariable Integer courseId) {
        model.addAttribute("course", studentService.getCourseByCourseId(courseId));

        return "student/course-detail";
    }
}
