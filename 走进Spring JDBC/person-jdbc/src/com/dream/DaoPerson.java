package com.dream;

import java.sql.*;
import java.util.*;
import javax.sql.*;
import org.apache.commons.dbcp2.*;

public class DaoPerson {
    public int addPerson(Person person) {
        int updatedCount = 0;
        Connection connection = null;
        PreparedStatement statement = null;
        SQLException sqlException = null;
        try {
            var sql = " INSERT INTO person"
                    + "   (person_name, person_gender)"
                    + " VALUES"
                    + "   (?, ?)";
            var dataSource = this.getDataSource();
            connection = dataSource.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setString(1, person.getName());
            statement.setString(2, person.getGender());
            updatedCount = statement.executeUpdate();
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
        return updatedCount;
    }

    public List<Person> queryPersonByName(String personName) {
        List<Person> personList = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        SQLException sqlException = null;
        try {
            var sql = " SELECT"
                    + "   person_id, person_name, person_gender"
                    + " FROM"
                    + "   person"
                    + " WHERE"
                    + "   person_name = ?";
            var dataSource = this.getDataSource();
            connection = dataSource.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setString(1, personName);
            var result = statement.executeQuery();
            while (result.next()) {
                var person = new Person();
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
        dataSource.setUrl("jdbc:mysql://localhost:3306/sj_person_jdbc");
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        return dataSource;
    }
}