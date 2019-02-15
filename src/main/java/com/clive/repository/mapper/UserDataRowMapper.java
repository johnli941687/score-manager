package com.clive.repository.mapper;

import com.clive.model.Department;
import com.clive.model.Major;
import com.clive.model.Role;
import com.clive.model.UserData;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class UserDataRowMapper implements RowMapper<UserData> {
    @Override
    public UserData mapRow(ResultSet resultSet, int i) throws SQLException {
        String userId = resultSet.getString("user_id");
        String username = resultSet.getString("user_name");
        String password = resultSet.getString("password");
        Integer age = resultSet.getInt("user_age");
        String gender = resultSet.getString("user_gender");
        String phone = resultSet.getString("phone");
        String email = resultSet.getString("email");
        LocalDateTime createTimestamp = convertSqlToLocal(resultSet.getTimestamp("created_on"));
        LocalDateTime modifyTimestamp = convertSqlToLocal(resultSet.getTimestamp("modified_on"));
        Department department = createDepartment(resultSet.getInt("dept_id"), resultSet.getString("dept_name"));
        Major major = createMajor(resultSet.getInt("major_id"), resultSet.getString("major_name"));
        Role role = createRole(resultSet.getInt("role_id"), resultSet.getString("role_name"));

        return new UserData(userId, username, password, age, gender, department, major, phone, email, role, createTimestamp, modifyTimestamp);
    }

    private LocalDateTime convertSqlToLocal(Timestamp createdOn) {
        return createdOn == null ? null : createdOn.toLocalDateTime();
    }

    private Role createRole(Integer roleId, String roleName) {
        return roleId == 0 ? null : new Role(roleId, roleName);
    }

    private Major createMajor(Integer majorNumber, String majorName) {
        return majorNumber == 0 ? null : new Major(majorNumber, majorName);
    }

    private Department createDepartment(Integer departmentNumber, String departmentName) {
        return departmentNumber == 0 ? null : new Department(departmentNumber, departmentName);
    }
}
