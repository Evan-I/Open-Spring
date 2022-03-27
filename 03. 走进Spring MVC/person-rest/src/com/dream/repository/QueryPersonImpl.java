package com.dream.repository;

import java.util.*;
import javax.sql.*;
import org.springframework.jdbc.core.*;
import org.springframework.stereotype.*;
import org.springframework.beans.factory.annotation.*;

@Repository
public class QueryPersonImpl implements QueryPerson {
    private static final String STATEMENT;
    private JdbcTemplate jdbcTemplate = null;

    @Autowired
    public void setJdbcTemplate(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<QueryPersonOut> access() {
        return this.jdbcTemplate.query(STATEMENT, (resultSet, i) ->{
            var person = new QueryPersonOut();
            person.setId(resultSet.getInt(1));
            person.setName(resultSet.getString(2));
            person.setGender(resultSet.getString(3));
            return person;
        });
    }

    static {
        STATEMENT = ""
        + " SELECT"
        + "   person_id, person_name, person_gender"
        + " FROM"
        + "   person";
    }
}