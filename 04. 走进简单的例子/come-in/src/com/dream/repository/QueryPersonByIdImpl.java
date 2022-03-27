package com.dream.repository;

import javax.sql.*;
import org.springframework.jdbc.core.*;
import org.springframework.stereotype.*;
import org.springframework.beans.factory.annotation.*;
import com.dream.*;

@Repository
public class QueryPersonByIdImpl implements QueryPersonById {
    private static final String STATEMENT;
    private JdbcTemplate jdbcTemplate = null;

    @Autowired
    public void setJdbcTemplate(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public QueryPersonByIdOut access(int id) {
        return this.jdbcTemplate.query(STATEMENT, preparedStatement -> {
            preparedStatement.setInt(1, id);
        }, resultSet -> {
            if (resultSet.next()) {
                var out = new QueryPersonByIdOut();
                out.setPersonId(resultSet.getInt(1));
                out.setPersonName(resultSet.getString(2));
                out.setPersonTime(Converter.toDate(resultSet.getString(3)));
                return out;
            } else {
                return null;
            }
        });
    }

    static {
        STATEMENT = ""
        + " SELECT"
        + "   person_id, person_name, person_time"
        + " FROM"
        + "   person"
        + " WHERE"
        + "   person_id=?";
    }
}