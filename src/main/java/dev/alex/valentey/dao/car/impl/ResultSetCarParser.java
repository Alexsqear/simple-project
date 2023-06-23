package dev.alex.valentey.dao.car.impl;

import dev.alex.valentey.dao.ResultSetParser;
import dev.alex.valentey.entity.Car;
import dev.alex.valentey.entity.Phone;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ResultSetCarParser implements ResultSetParser {
    @Override
    public <T> T parseObject(ResultSet resultSet) {
        long id = 0;
        int serialNumber = 0;
        String mark = null;
        String model = null;
        try {
            id = resultSet.getLong("car_id");
            serialNumber = resultSet.getInt("serialNumber");
            mark = resultSet.getString("mark");
            model = resultSet.getString("model");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        Car car = new Car(id, serialNumber,mark,model);
        return (T) car;
    }
}
