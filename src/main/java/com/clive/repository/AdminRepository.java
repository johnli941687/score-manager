package com.clive.repository;

import com.clive.model.User;
import com.clive.model.UserData;
import com.clive.repository.mapper.UserDataRowMapper;
import com.clive.repository.mapper.UserRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class AdminRepository {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public AdminRepository(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<UserData> getAllUsers() {
        String query = "SELECT user_id, user_num, user_name, password, user_age, user_gender, department, major, phone, email, role_name FROM user INNER JOIN role ON user.role_id = role.role_id;";

        return jdbcTemplate.query(query, new UserDataRowMapper());
    }

    public void saveUser(UserData userData) {
        String query = "INSERT INTO user (user_num, user_name, user_age, user_gender, department, major, phone, email) VALUES (?,?,?,?,?,?,?,?)";

        jdbcTemplate.update(query, userData.getUserId(), userData.getUsername(), userData.getAge(), userData.getGender(), userData.getDepartment(),
                userData.getMajor(), userData.getPhone(), userData.getEmail());
    }

    public Integer getRoleIdByRoleName(String role) {
        String query = "SELECT role_id FROM role WHERE role_name = ?";

        try {
            return jdbcTemplate.queryForObject(query, Integer.class, role);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    public User getUserByUsername(String username) {
        String query = "SELECT user_num, password, role_name FROM user INNER JOIN role ON user.role_id = role.role_id WHERE user_num = ?;";

        try {
            return jdbcTemplate.queryForObject(query, new UserRowMapper(), username);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }
}
