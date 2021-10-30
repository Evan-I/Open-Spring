package com.dream;

import java.sql.*;
import java.util.*;
import javax.sql.*;
import org.apache.commons.dbcp2.*;
import org.springframework.dao.*;
import org.springframework.jdbc.core.*;
import org.springframework.jdbc.support.*;

public class DaoPerson {
    public int addPerson(Person person) {
        var sql = " INSERT INTO person"
                + "   (person_name, person_gender)"
                + " VALUES"
                + "   (?, ?)";
        var dataSource = this.getDataSource();
        var jdbcTemplate = new JdbcTemplate(dataSource);
        var updatedCount = jdbcTemplate.update(sql, new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement preparedStatement) throws SQLException {
                preparedStatement.setString(1, person.getName());
                preparedStatement.setString(2, person.getGender());
            }
        });
        return updatedCount;
    }

    public int deletePersonByName(String personName) {
        var sql = "DELETE FROM person WHERE person_name = ?";
        var dataSource = this.getDataSource();
        var jdbcTemplate = new JdbcTemplate(dataSource);
        var updatedCount = jdbcTemplate.update(sql, new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement preparedStatement) throws SQLException {
                preparedStatement.setString(1, personName);
            }
        });
        return updatedCount;
    }

    public int updatePersonByName(String personName, String newPersonName) {
        var sql = "UPDATE person SET person_name = ? WHERE person_name = ?";
        var dataSource = this.getDataSource();
        var jdbcTemplate = new JdbcTemplate(dataSource);
        var updatedCount = jdbcTemplate.update(sql, new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement preparedStatement) throws SQLException {
                preparedStatement.setString(1, newPersonName);
                preparedStatement.setString(2, personName);
            }
        });
        return updatedCount;
    }

    public int countPersons() {
        var sql = "SELECT COUNT(*) FROM person";
        var dataSource = this.getDataSource();
        var jdbcTemplate = new JdbcTemplate(dataSource);
        var count = jdbcTemplate.query(sql, new ResultSetExtractor<Integer>() {
            @Override
            public Integer extractData(ResultSet resultSet) throws SQLException, DataAccessException {
                return resultSet.next() ? resultSet.getInt(1) : 0;
            }
        });
        return count;
    }

    public Person queryPersonById(int id) {
        var sql = " SELECT"
                + "   person_id, person_name, person_gender"
                + " FROM"
                + "   person"
                + " WHERE"
                + "   person_id = ?";
        var dataSource = this.getDataSource();
        var jdbcTemplate = new JdbcTemplate(dataSource);
        var person = jdbcTemplate.query(sql, new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement preparedStatement) throws SQLException {
                preparedStatement.setInt(1, id);
            }
        }, new ResultSetExtractor<Person>() {
            @Override
            public Person extractData(ResultSet resultSet) throws SQLException, DataAccessException {
                if (resultSet.next()) {
                    var person = new Person();
                    person.setId(resultSet.getInt(1));
                    person.setName(resultSet.getString(2));
                    person.setGender(resultSet.getString(3));
                    return person;
                } else {
                    return null;
                }
            }
        });
        return person;
    }

    public List<Person> queryPersonByName(String personName) {
        var sql = " SELECT"
                + "   person_id, person_name, person_gender"
                + " FROM"
                + "   person"
                + " WHERE"
                + "   person_name = ?";
        var dataSource = this.getDataSource();
        var jdbcTemplate = new JdbcTemplate(dataSource);
        var personList = jdbcTemplate.query(sql, new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement preparedStatement) throws SQLException {
                preparedStatement.setString(1, personName);
            }
        }, new RowMapper<Person>() {
            @Override
            public Person mapRow(ResultSet resultSet, int i) throws SQLException {
                var person = new Person();
                person.setId(resultSet.getInt(1));
                person.setName(resultSet.getString(2));
                person.setGender(resultSet.getString(3));
                return person;
            }
        });
        return personList;
    }

    private DataSource getDataSource() {
        var dataSource = new BasicDataSource();
        dataSource.setUsername("root");
        dataSource.setPassword("123456");
        dataSource.setUrl("jdbc:mysql://localhost:3306/sj_person_spring");
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        return dataSource;
    }
}