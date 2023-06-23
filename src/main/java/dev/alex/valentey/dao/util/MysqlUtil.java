package dev.alex.valentey.dao.util;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import dev.alex.valentey.dao.ResultSetParser;
import dev.alex.valentey.entity.Person;

import java.sql.*;
import java.util.ArrayList;

public class MysqlUtil<T> {
    public static final String MYSQL_JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    public static final String JDBC_URL = "jdbc:mysql://localhost:3306/my_crud_database";
    public static final String JDBC_USER = "root";
    public static final String JDBC_PASSWORD = "5alexsqearValgad@";

    private static HikariDataSource dataSource = null;

    static {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(JDBC_URL);
        config.setUsername(JDBC_USER);
        config.setPassword(JDBC_PASSWORD);
        config.addDataSourceProperty("minimumIdle", "5");
        config.addDataSourceProperty("maximumPoolSize", "25");

        dataSource = new HikariDataSource(config);
    }

    public static Connection getConnection() {
        Connection connection;
        try {
            Class.forName(MYSQL_JDBC_DRIVER);
//            connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
            connection = dataSource.getConnection();
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        return connection;
    }

    /**
     * This method execute sql query for INSERT, UPDATE, DELETE operations on database.
     *
     * @param sql - a String value of sql query
     */
    public static void executeSqlQuery(String sql) {
        Statement statement = null;
        Connection connection = null;
        try {
            //2. connection
            connection = MysqlUtil.getConnection();
            //3. statement
            statement = connection.createStatement();
            //4. execute sql query
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                statement.close();
                connection.close();
            } catch (SQLException e) {
                /*do nothing*/
            }
        }
    }

    public static void executeSqlQueryTryWithResources(String sql) {
        try (Connection connection = MysqlUtil.getConnection();
             Statement statement = connection.createStatement()) {
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static <T> ArrayList<T> executeSqlReadQuery(String sql, ResultSetParser parser) {
        ArrayList<T> objectList = new ArrayList<>();
        try {
            //2. connection
            Connection connection = MysqlUtil.getConnection();

            //3. statement
            Statement statement = connection.createStatement();

            //4. execute sql query
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                T object = (T) parser.parseObject(resultSet);
                objectList.add(object);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return objectList;
    }


}
