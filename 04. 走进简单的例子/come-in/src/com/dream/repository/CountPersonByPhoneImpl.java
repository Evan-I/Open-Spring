package com.dream.repository;

import javax.sql.DataSource;
import org.springframework.jdbc.core.*;
import org.springframework.stereotype.*;
import org.springframework.beans.factory.annotation.*;

@Repository
public class CountPersonByPhoneImpl implements CountPersonByPhone {
    private static final String STATEMENT;
    private JdbcTemplate jdbcTemplate = null;

    @Autowired
    public void setJdbcTemplate(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public int access(String phone) {
        return this.jdbcTemplate.query(STATEMENT, preparedStatement -> {
            preparedStatement.setString(1, phone);
        }, resultSet -> resultSet.next() ? resultSet.getInt(1) : 0);
    }

    static {
        STATEMENT = "SELECT COUNT(*) FROM person WHERE person_phone=?";
    }
}