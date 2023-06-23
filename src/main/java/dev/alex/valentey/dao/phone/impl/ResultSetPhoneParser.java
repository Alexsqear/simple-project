package dev.alex.valentey.dao.phone.impl;

import dev.alex.valentey.dao.ResultSetParser;
import dev.alex.valentey.entity.Passport;
import dev.alex.valentey.entity.Phone;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ResultSetPhoneParser implements ResultSetParser {
    @Override

    public <T> T parseObject(ResultSet resultSet) {
        long id = 0;
        String countryCode = null;
        int operatorCode = 0;
        int phoneNumber = 0;
        try {
            id = resultSet.getLong("phone_id");
            countryCode = resultSet.getString("countryCode");
            operatorCode = resultSet.getInt("operatorCode");
            phoneNumber = resultSet.getInt("phoneNumber");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        Phone phone = new Phone(id, countryCode, operatorCode,phoneNumber);
        return (T) phone;
    }
}

