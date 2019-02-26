package com.clive.repository.mapper;

import com.clive.model.Course;
import com.clive.model.Semester;
import com.clive.model.User;
import com.clive.model.UserData;
import org.springframework.jdbc.core.RowMapper;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class CourseRowMapper implements RowMapper<Course> {
    @Override
    public Course mapRow(ResultSet resultSet, int i) throws SQLException {
        Integer courseId = resultSet.getInt("course_id");
        String courseName = resultSet.getString("course_name");
        Integer courseCredit = resultSet.getInt("course_credit");
        Integer courseHours = resultSet.getInt("course_hours");
        String overview = resultSet.getString("overview");
        String audience = resultSet.getString("audience");
        String prerequisites = resultSet.getString("prerequisites");
        String outline = resultSet.getString("outline");
        Integer semesterId = resultSet.getInt("semester_id");
        String semesterName = resultSet.getString("semester_name");
        LocalDate startDate = convertSqlToLocalDate(resultSet.getDate("start_date"));
        LocalDate endDate = convertSqlToLocalDate(resultSet.getDate("end_date"));
        String userId = resultSet.getString("user_id");
        String username = resultSet.getString("user_name");

        Semester semester = new Semester(semesterId, semesterName, startDate, endDate);
        UserData teacher = new UserData();
        teacher.setUserId(userId);
        teacher.setUsername(username);

        return new Course(courseId, courseName, courseCredit, courseHours, teacher, semester, overview, audience, prerequisites, outline);
    }

    private LocalDate convertSqlToLocalDate(Date date) {
        return date == null ? null : date.toLocalDate();
    }
}
