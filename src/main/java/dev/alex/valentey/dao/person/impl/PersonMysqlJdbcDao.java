package dev.alex.valentey.dao.person.impl;

import dev.alex.valentey.dao.PersonDao;
import dev.alex.valentey.dao.util.MysqlUtil;
import dev.alex.valentey.entity.Person;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PersonMysqlJdbcDao implements PersonDao {


    public static void main(String[] args) {
//        new PersonMysqlJdbcDao().createNewPerson(new Person("sam", 39));
//        new PersonMysqlJdbcDao().deletePersonById(5);
//        new PersonMysqlJdbcDao().updatePerson(new Person(2, "sam_fisher", 27));
//        List<Person> personList = new PersonMysqlJdbcDao().readAllPersons();

//        Person person = new PersonMysqlJdbcDao().readPersonById(5);
//        System.out.println();
//        List<Person> collect = Stream.of(new Person("rr", 100), new Person("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee", 2000), new Person("kk", 300)).collect(Collectors.toList());
//        new PersonMysqlJdbcDao().createPersons(collect);

        new PersonMysqlJdbcDao().incrementPersonAge();
        new PersonMysqlJdbcDao().incrementPersonAge();
        new PersonMysqlJdbcDao().incrementPersonAge();
        new PersonMysqlJdbcDao().incrementPersonAge();
        new PersonMysqlJdbcDao().incrementPersonAge();
        new PersonMysqlJdbcDao().incrementPersonAge();
        new PersonMysqlJdbcDao().incrementPersonAge();
        new PersonMysqlJdbcDao().incrementPersonAge();

    }

    public void incrementPersonAge(){
        String sql = "call increment_person_age();";
        Connection connection = null;
        CallableStatement statement = null;
        try {
            //2. connection
            connection = MysqlUtil.getConnection();
            //3. statement
            statement = connection.prepareCall(sql);

            //4. execute sql query
            statement.execute();
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

    @Override
    public void createNewPerson(Person person) {
//        String sql = String.format("INSERT INTO `my_crud_database`.`person` (`name`, `age`) VALUES ('%s',%d)", person.getName(), person.getAge());
//        MysqlUtil.executeSqlQuery(sql);
        String sql = "INSERT INTO `my_crud_database`.`person` (`name`, `age`) VALUES (?, ?)";

        PreparedStatement statement = null;
        Connection connection = null;
        try {
            //2. connection
            connection = MysqlUtil.getConnection();
            //3. statement
            statement = connection.prepareStatement(sql);
            statement.setString(1, person.getName());
            statement.setInt(2, person.getAge());
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

    public void createPersons(List<Person> personList) {

        try (Connection connection = MysqlUtil.getConnection(); Statement statement = connection.createStatement()) {

            //begin transaction in manual mode
            connection.setAutoCommit(false);
            try {
                for (Person person : personList) {
                    String sql = String.format("INSERT INTO `my_crud_database`.`person` (`name`, `age`) VALUES ('%s',%d)", person.getName(), person.getAge());
                    statement.executeUpdate(sql);
                }
                connection.commit();
            } catch (SQLException e) {
                connection.rollback();
            }

        } catch (SQLException e) {

            throw new RuntimeException(e);
        }
    }


    @Override
    public void updatePerson(Person updatedPerson) {
        String sql = "UPDATE `my_crud_database`.`person` SET `name` = '" + updatedPerson.getName() + "'," + " `age` = " + updatedPerson.getAge() + " WHERE (`person_id` = " + updatedPerson.getPersonId() + ")";
        MysqlUtil.executeSqlQuery(sql);
    }

    @Override
    public void deletePersonById(long deletedId) {
        String sql = "DELETE FROM `my_crud_database`.`person` WHERE (`person_id` = '" + deletedId + "')";
        MysqlUtil.executeSqlQuery(sql);
    }

    @Override
    public List<Person> readAllPersons() {
        String sql = "SELECT * FROM my_crud_database.person";

        ArrayList<Person> personList = MysqlUtil.executeSqlReadQuery(sql, new ResultSetPersonParser());
        return personList;
    }

    @Override
    public Person readPersonById(long personId) {
        String sql = String.format("SELECT * FROM my_crud_database.person where person_id = %s", personId);
        ArrayList<Person> personList = MysqlUtil.executeSqlReadQuery(sql, new ResultSetPersonParser());
        if (!personList.isEmpty()) {
            return personList.get(0);
        }
        return new Person();
    }


}
