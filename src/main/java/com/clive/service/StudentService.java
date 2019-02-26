package com.clive.service;

import com.clive.model.Course;
import com.clive.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public List<Course> getAllCourses(String username) {
        List<Course> allCourses = studentRepository.getAllCourses();
        List<Course> coursesRegisteredBy = studentRepository.getCoursesRegisteredBy(username);
        coursesRegisteredBy.forEach(c1 -> {
            Course course = allCourses.stream().filter(c2 -> c1.getId() == c2.getId()).findFirst().get();
            course.setRegistered(true);
        });

        return allCourses;
    }

    public void registerCourse(String username, Integer courseId) {
        studentRepository.registerCourse(username, courseId);
    }

    public Course getCourseByCourseId(Integer courseId) {
        return studentRepository.getCourseByCourseId(courseId);
    }

    public Integer add(Integer number1, Integer number2) {
        return number1 + number2;
    }
}
