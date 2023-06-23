package dev.alex.valentey.dao.passport.impl;

import dev.alex.valentey.dao.ResultSetParser;
import dev.alex.valentey.entity.Passport;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ResultSetPassportParser implements ResultSetParser {
    @Override
    public <T> T parseObject(ResultSet resultSet) {
        long id = 0;
        String name = null;
        String place = null;
        try {
            id = resultSet.getLong("passportId");
            name = resultSet.getString("series");
            place = resultSet.getString("place");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        Passport passport = new Passport(id, name, place);
        return (T) passport;
    }
}
