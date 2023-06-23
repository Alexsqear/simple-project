package dev.alex.valentey.dao.person.impl;

import dev.alex.valentey.dao.ResultSetParser;
import dev.alex.valentey.entity.Person;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ResultSetPersonParser implements ResultSetParser {

    @Override
    public <T> T parseObject(ResultSet resultSet) {
        long id = 0;
        String name = null;
        int age = 0;
        try {
            id = resultSet.getLong("person_id");
            name = resultSet.getString(2);
            age = resultSet.getInt("age");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        Person person = new Person(id, name, age);
        return (T) person;
    }
}
