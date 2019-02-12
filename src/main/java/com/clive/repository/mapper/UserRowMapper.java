package com.clive.repository.mapper;

import com.clive.model.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRowMapper implements RowMapper<User> {
    public User mapRow(ResultSet resultSet, int i) throws SQLException {
        return new User(resultSet.getString("user_num"), resultSet.getString("password"), resultSet.getString("role_name"));
    }
}
