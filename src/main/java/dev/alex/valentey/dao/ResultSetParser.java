package dev.alex.valentey.dao;

import java.sql.ResultSet;

public interface ResultSetParser {
     <T> T parseObject(ResultSet resultSet);
}
