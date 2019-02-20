package com.clive.repository.mapper;

import com.clive.model.Semester;
import org.springframework.jdbc.core.RowMapper;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class SemesterRowMapper implements RowMapper<Semester> {
    @Override
    public Semester mapRow(ResultSet resultSet, int i) throws SQLException {
        return new Semester(
                resultSet.getInt("semester_id"),
                resultSet.getString("semester_name"),
                convertSqlToLocalDate(resultSet.getDate("start_date")),
                convertSqlToLocalDate(resultSet.getDate("end_date"))
        );
    }

    private LocalDate convertSqlToLocalDate(Date date) {
        return date == null ? null : date.toLocalDate();
    }
}
