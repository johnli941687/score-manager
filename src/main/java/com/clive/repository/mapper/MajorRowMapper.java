package com.clive.repository.mapper;

import com.clive.model.Major;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MajorRowMapper implements RowMapper<Major>{
    @Override
    public Major mapRow(ResultSet resultSet, int i) throws SQLException {
        return new Major(resultSet.getInt("major_id"), resultSet.getString("major_name"));
    }
}
