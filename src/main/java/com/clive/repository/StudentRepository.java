package com.clive.repository;

import com.clive.model.Course;
import com.clive.model.Semester;
import com.clive.repository.mapper.CourseRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.JDBCType;
import java.util.List;

@Repository
public class StudentRepository {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public StudentRepository(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }


    public List<Course> getAllCourses() {
        String query = "SELECT course.course_id,\n" +
                "       course.course_name,\n" +
                "       course.course_credit,\n" +
                "       course.course_hours,\n" +
                "       semester.semester_id,\n" +
                "       semester.semester_name,\n" +
                "       semester.start_date,\n" +
                "       semester.end_date,\n" +
                "       user.user_id,\n" +
                "       user.user_name\n" +
                "FROM course\n" +
                "       LEFT JOIN user ON course.teacher_id = user.user_id\n" +
                "       LEFT JOIN semester ON course.semester_id = semester.semester_id";

        return jdbcTemplate.query(query, new CourseRowMapper());
    }

    public void registerCourse(String username, Integer courseId) {
        String query = "INSERT INTO course_enrollment (student_id, course_id) VALUES (?,?)";

        jdbcTemplate.update(query, username, courseId);
    }

    public List<Course> getCoursesRegisteredBy(String username) {
        String query = "SELECT course.course_id,\n" +
                "       course.course_name,\n" +
                "       course.course_credit,\n" +
                "       course.course_hours,\n" +
                "       semester.semester_id,\n" +
                "       semester.semester_name,\n" +
                "       semester.start_date,\n" +
                "       semester.end_date,\n" +
                "       user.user_id,\n" +
                "       user.user_name\n" +
                "FROM course\n" +
                "       INNER JOIN course_enrollment ON course.course_id = course_enrollment.course_id\n" +
                "       LEFT JOIN user ON course.teacher_id = user.user_id\n" +
                "       LEFT JOIN semester ON course.semester_id = semester.semester_id\n" +
                "WHERE course_enrollment.student_id = ?;";

        return jdbcTemplate.query(query, new CourseRowMapper(), username);
    }
}
