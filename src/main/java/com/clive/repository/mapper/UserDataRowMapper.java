package com.clive.repository.mapper;

import com.clive.model.UserData;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDataRowMapper implements RowMapper<UserData> {
    @Override
    public UserData mapRow(ResultSet resultSet, int i) throws SQLException {
        return new UserData(resultSet.getInt("user_id"),
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
