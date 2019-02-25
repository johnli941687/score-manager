package com.clive.controller;

import com.clive.model.Course;
import com.clive.model.User;
import com.clive.model.UserData;
import com.clive.service.TeacherService;
import com.clive.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/teacher")
public class TeacherController {
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private UserService userService;

    @GetMapping("/courses")
    public String showAllCourses(Model model) {
        model.addAttribute("courses", teacherService.getAllCourses());

        return "teacher/courses";
    }

    @GetMapping("/course")
    public String showAddCourseForm(Model model) {

        model.addAttribute("course", teacherService.createNewCourse());
        model.addAttribute("semesters", teacherService.getAllSemesters());

        return "teacher/create-course";
    }

    @PostMapping("/course")
    public String addCourse(Model model, @Valid @ModelAttribute Course course, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("course", course);
            model.addAttribute("semesters", teacherService.getAllSemesters());

            return "teacher/create-course";
        }

        teacherService.saveCourse(course);

        return "redirect:/teacher/courses";
    }

    @GetMapping("/course/{courseId}")
    public String updateCourseForm(Model model, @PathVariable Integer courseId) {
        model.addAttribute("course", teacherService.getCourseById(courseId));
        model.addAttribute("semesters", teacherService.getAllSemesters());

        return "teacher/edit-course";
    }

    @PostMapping("/course/{courseId}")
    public String updateCourse(Model model, @PathVariable Integer courseId, @Valid @ModelAttribute Course course, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("course", course);
            model.addAttribute("semesters", teacherService.getAllSemesters());

            return "teacher/edit-course";
        }
        course.setId(courseId);
        teacherService.updateCourse(course);

        return "redirect:/teacher/courses";
    }

    @GetMapping("/course/{courseId}/delete")
    public String deleteCourse(@PathVariable Integer courseId) {
        teacherService.deleteCourseById(courseId);

        return "redirect:/teacher/courses";
    }

    @GetMapping("/course/{courseId}/grade")
    public String inputGrade(Model model, @PathVariable Integer courseId) {
        List<UserData> studentsForCourse = teacherService.getStudentForCourse(courseId);

        return null;
    }


}
