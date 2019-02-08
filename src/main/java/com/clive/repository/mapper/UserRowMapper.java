package com.clive.repository.mapper;

import com.clive.model.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRowMapper implements RowMapper<User> {
    @Override
    public User mapRow(ResultSet resultSet, int i) throws SQLException {
        return new User(resultSet.getInt("user_id"),
                resultSet.getString("user_num"),
                resultSet.getString("user_name"),
                resultSet.getString("password"),
                resultSet.getInt("user_age"),
                resultSet.getString("user_gender"),
                resultSet.getString("department"),
                resultSet.getString("major"),
                resultSet.getString("phone"),
                resultSet.getString("email"),
                resultSet.getString("role_name"));
    }
}
