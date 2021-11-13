package com.dream.repository;

import javax.sql.*;
import org.springframework.jdbc.core.*;
import org.springframework.stereotype.*;
import org.springframework.beans.factory.annotation.*;

@Repository
public class AddPersonImpl implements AddPerson {
    private static final String STATEMENT;
    private JdbcTemplate jdbcTemplate = null;

    @Autowired
    public void setJdbcTemplate(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void access(String name, String phone, String password) {
        this.jdbcTemplate.update(STATEMENT, preparedStatement -> {
            preparedStatement.setString(1, phone);
            preparedStatement.setString(2, password);
            preparedStatement.setString(3, name);
        });
    }

    static {
        STATEMENT = ""
        + " INSERT INTO person"
        + "   (person_phone, person_password, person_name, person_time)"
        + " VALUES"
        + "   (?, ?, ?, NOW())";
    }
}