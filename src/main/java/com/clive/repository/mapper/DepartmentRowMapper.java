package com.clive.repository.mapper;

import com.clive.model.Department;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DepartmentRowMapper implements RowMapper<Department> {
    @Override
    public Department mapRow(ResultSet resultSet, int i) throws SQLException {
        return new Department(resultSet.getInt("dept_id"), resultSet.getString("dept_name"));
    }
}
