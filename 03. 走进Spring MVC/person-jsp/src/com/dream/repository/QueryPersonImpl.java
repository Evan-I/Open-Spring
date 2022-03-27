package com.dream.repository;

import java.sql.*;
import java.util.*;
import javax.sql.*;
import org.apache.commons.dbcp2.*;

public class QueryPersonImpl implements QueryPerson {
    private static final String STATEMENT;
    private final DataSource dataSource = this.getDataSource();

    @Override
    public List<QueryPersonOut> access() {
        Connection connection = null;
        PreparedStatement statement = null;
        SQLException sqlException = null;
        var personList = new ArrayList<QueryPersonOut>();
        try {
            connection = this.dataSource.getConnection();
            statement = connection.prepareStatement(STATEMENT);
            var result = statement.executeQuery();
            while (result.next()) {
                var person = new QueryPersonOut();
                person.setId(result.getInt(1));
                person.setName(result.getString(2));
                person.setGender(result.getString(3));
                personList.add(person);
            }
        } catch (SQLException e) {
            sqlException = e;
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    if (sqlException == null) {
                        sqlException = e;
                    }
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    if (sqlException == null) {
                        sqlException = e;
                    }
                }
            }
            if (sqlException != null) {
                throw new RuntimeException(sqlException);
            }
        }
        return personList;
    }

    private DataSource getDataSource() {
        var dataSource = new BasicDataSource();
        dataSource.setUsername("root");
        dataSource.setPassword("123456");
        dataSource.setUrl("jdbc:mysql://localhost:3306/sm_person_jsp");
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        return dataSource;
    }

    static {
        STATEMENT = ""
        + " SELECT"
        + "   person_id, person_name, person_gender"
        + " FROM"
        + "   person";
    }
}