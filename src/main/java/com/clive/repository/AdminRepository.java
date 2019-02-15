package com.clive.repository;

import com.clive.model.*;
import com.clive.repository.mapper.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

import static java.sql.Timestamp.valueOf;
import static java.time.LocalDateTime.now;

@Repository
public class AdminRepository {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public AdminRepository(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<UserData> getAllUsers() {
        String query = "SELECT user.user_id,\n" +
                "       user.user_name,\n" +
                "       user.password,\n" +
                "       user.user_age,\n" +
                "       user.user_gender,\n" +
                "       user.phone,\n" +
                "       user.email,\n" +
                "       user.created_on,\n" +
                "       user.modified_on,\n" +
                "       department.dept_id,\n" +
                "       department.dept_name,\n" +
                "       major.major_id,\n" +
                "       major.major_name,\n" +
                "       role.role_id,\n" +
                "       role.role_name\n" +
                "FROM user\n" +
                "       LEFT JOIN major ON user.major_id = major.major_id\n" +
                "       LEFT JOIN department ON user.department_id = department.dept_id\n" +
                "       LEFT JOIN role ON user.role_id = role.role_id";

        return jdbcTemplate.query(query, new UserDataRowMapper());
    }

    public void saveUser(UserData userData) {
        String query = "INSERT INTO user (user_id, user_name, user_age, user_gender, phone, email, department_id, major_id, role_id, created_on) VALUES (?,?,?,?,?,?,?,?,?,?)";

        jdbcTemplate.update(query, userData.getUserId(), userData.getUsername(), userData.getAge(), userData.getGender(), userData.getPhone(), userData.getEmail(),
                userData.getDepartment().getDepartmentNumber(), userData.getMajor().getMajorNumber(), userData.getRole().getRoleId(), valueOf(now()));
    }

    public User getUserByUsername(String username) {
        String query = "SELECT user_id, password, role_name FROM user INNER JOIN role ON user.role_id = role.role_id WHERE user_id = ?;";

        try {
            return jdbcTemplate.queryForObject(query, new UserRowMapper(), username);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    public UserData getUserDataByUsername(String username) {
        String query = "SELECT user.user_id,\n" +
                "       user.user_name,\n" +
                "       user.password,\n" +
                "       user.user_age,\n" +
                "       user.user_gender,\n" +
                "       user.phone,\n" +
                "       user.email,\n" +
                "       user.created_on,\n" +
                "       user.modified_on,\n" +
                "       department.dept_id,\n" +
                "       department.dept_name,\n" +
                "       major.major_id,\n" +
                "       major.major_name,\n" +
                "       role.role_id,\n" +
                "       role.role_name\n" +
                "FROM user\n" +
                "       LEFT JOIN major ON user.major_id = major.major_id\n" +
                "       LEFT JOIN department ON user.department_id = department.dept_id\n" +
                "       LEFT JOIN role ON user.role_id = role.role_id\n" +
                "WHERE user.user_id = ?";

        try {
            return jdbcTemplate.queryForObject(query, new UserDataRowMapper(), username);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    public List<Department> getDepartments() {
        String query = "SELECT dept_id, dept_name FROM department";

        return jdbcTemplate.query(query, new DepartmentRowMapper());
    }

    public List<Major> getMajorByDepartmentNumber(Integer departmentNumber) {
        String query = "SELECT major_id, major_name FROM major WHERE dept_id = ?";

        return jdbcTemplate.query(query, new MajorRowMapper(), departmentNumber);
    }

    public List<Role> getAllRoles() {
        String query = "SELECT role_id, role_name FROM role";

        return jdbcTemplate.query(query, new RoleRowMapper());
    }

    public void updateUserData(UserData userData, String userId) {
        String query = "UPDATE user\n" +
                "SET user_id            = ?,\n" +
                "    user_name          = ?,\n" +
                "    user_age           = ?,\n" +
                "    user_gender        = ?,\n" +
                "    user.phone         = ?,\n" +
                "    user.email         = ?,\n" +
                "    user.department_id = ?,\n" +
                "    user.major_id      = ?,\n" +
                "    user.role_id       = ?,\n" +
                "    modified_on        = ?\n" +
                "WHERE user_id = ?";

        jdbcTemplate.update(query, userData.getUserId(), userData.getUsername(), userData.getAge(), userData.getGender(), userData.getPhone(), userData.getEmail(),
                userData.getDepartment() == null ? null : userData.getDepartment().getDepartmentNumber(), userData.getMajor() == null ? null : userData.getMajor().getMajorNumber(),
                userData.getRole().getRoleId(), valueOf(now()), userId);
    }
}
