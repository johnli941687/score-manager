package com.clive.repository;

import com.clive.model.Course;
import com.clive.model.Semester;
import com.clive.repository.mapper.CourseRowMapper;
import com.clive.repository.mapper.SemesterRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class TeacherRepository {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public TeacherRepository(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }


    public List<Semester> getAllSemesters() {
        String query = "SELECT semester_id, semester_name, start_date, end_date FROM semester ORDER BY start_date DESC";

        return jdbcTemplate.query(query, new SemesterRowMapper());
    }

    public List<Course> getAllCoursesByTeacherId(String teacherId) {
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
                "       LEFT JOIN semester ON course.semester_id = semester.semester_id\n" +
                "WHERE course.teacher_id = ?;";

        return jdbcTemplate.query(query, new CourseRowMapper(), teacherId);
    }

    public void saveCourse(Course course) {
        String query = "INSERT INTO course (course_name, course_credit, course_hours, teacher_id, semester_id) VALUES (?,?,?,?,?)";

        jdbcTemplate.update(query, course.getName(), course.getCredit(), course.getHours(), course.getTeacher().getUserId(), course.getSemester().getId());
    }

    public Course getCourseById(Integer courseId) {
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
                "       LEFT JOIN semester ON course.semester_id = semester.semester_id\n" +
                "WHERE course.course_id = ?;";

        try {
            return jdbcTemplate.queryForObject(query, new CourseRowMapper(), courseId);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    public void updateCourse(Course course) {
        String query = "UPDATE course\n" +
                "SET course_name   = ?,\n" +
                "    course_credit = ?,\n" +
                "    course_hours  = ?,\n" +
                "    semester_id   = ?,\n" +
                "    teacher_id    = ?\n" +
                "WHERE course_id = ?";

        jdbcTemplate.update(query, course.getName(), course.getCredit(), course.getHours(), course.getSemester().getId(), course.getTeacher().getUserId());
    }
}
