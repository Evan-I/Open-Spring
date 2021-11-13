package com.dream.repository;

import javax.sql.*;
import org.springframework.jdbc.core.*;
import org.springframework.stereotype.*;
import org.springframework.beans.factory.annotation.*;

@Repository
public class QueryPersonIdByCredentialImpl implements QueryPersonIdByCredential {
    private static final String STATEMENT;
    private JdbcTemplate jdbcTemplate = null;

    @Autowired
    public void setJdbcTemplate(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public int access(String phone, String password) {
        return this.jdbcTemplate.query(STATEMENT, preparedStatement -> {
            preparedStatement.setString(1, phone);
            preparedStatement.setString(2, password);
        }, resultSet -> resultSet.next() ? resultSet.getInt(1) : 0);
    }

    static {
        STATEMENT = ""
        + " SELECT"
        + "   person_id"
        + " FROM"
        + "   person"
        + " WHERE"
        + "   person_phone=? AND person_password=?";
    }
}