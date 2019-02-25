package com.clive.service;

import com.clive.model.Course;
import com.clive.model.Semester;
import com.clive.model.User;
import com.clive.model.UserData;
import com.clive.repository.AdminRepository;
import com.clive.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;

@Service
public class TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;
    @Autowired
    private AdminRepository adminRepository;
    @Autowired
    private UserService userService;

    public List<Semester> getAllSemesters() {
        return teacherRepository.getAllSemesters();
    }

    public Course createNewCourse() {
        Course course = new Course();
        course.setTeacher(getUserDataByCurrentUser());

        return course;
    }

    private UserData getUserDataByCurrentUser() {

        return adminRepository.getUserDataByUserId(userService.getCurrentUser().getUsername());
    }

    public void saveCourse(Course course) {
        course.setTeacher(adminRepository.getUserDataByUsername(course.getTeacher().getUsername()));
        teacherRepository.saveCourse(course);
    }

    public List<Course> getAllCourses() {
        String teacherId = getUserDataByCurrentUser().getUserId();

        return teacherRepository.getAllCoursesByTeacherId(teacherId);
    }

    public Course getCourseById(Integer courseId) {
        return teacherRepository.getCourseById(courseId);
    }

    public void updateCourse(Course course) {
        course.setTeacher(adminRepository.getUserDataByUsername(course.getTeacher().getUsername()));

        teacherRepository.updateCourse(course);
    }

    public void deleteCourseById(Integer courseId) {
        teacherRepository.deleteCourseById(courseId);
    }

    public List<UserData> getStudentForCourse(Integer courseId) {
        return teacherRepository.getAllStudentsForCourse(courseId);
    }
}
