package com.clive.repository;

import com.clive.model.User;
import com.clive.repository.mapper.UserRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
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

    public List<User> getAllUsers() {
        String query = "SELECT user_id, user_num, user_name, password, user_age, user_gender, department, major, phone, email, role_name FROM user INNER JOIN role ON user.role_id = role.role_id;";

        return jdbcTemplate.query(query, new UserRowMapper());
    }
}
