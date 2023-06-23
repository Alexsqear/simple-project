package dev.alex.valentey.dao.passport.impl;

import dev.alex.valentey.dao.PassportDao;
import dev.alex.valentey.dao.util.MysqlUtil;
import dev.alex.valentey.entity.Passport;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PassportMysqlJdbcDao implements PassportDao {

    public static void main(String[] args) {
        new PassportMysqlJdbcDao().readAllPassports();
    }

    private static List<Passport> passportList = Stream.of(
            new Passport("mp", "Фр.РУВД"),
            new Passport("gh", "ruvd"),
            new Passport("tp", "secruvd")
    ).collect(Collectors.toList());

    @Override
    public Passport readPassportById(long passportId) {
        String sql = String.format("SELECT * FROM my_crud_database.passport where passportId = %s", passportId);
        ArrayList<Passport> passportList = MysqlUtil.executeSqlReadQuery(sql, new ResultSetPassportParser());
        if (!passportList.isEmpty()) {
            return passportList.get(0);
        }
        return new Passport();
    }

    @Override
    public void createNewPassport(Passport passport) {
        String sql = String.format("INSERT INTO `my_crud_database`.`passport` (`series`, `place`,) VALUES ('%s',%d)", passport.getSeries(), passport.getPlace());
        MysqlUtil.executeSqlQuery(sql);
    }

    @Override
    public void updatePassport(Passport updatedPassport) {
        String sql = "UPDATE `my_crud_database`.`passport` SET `series` = '" + updatedPassport.getSeries() + "'," +
                " `place` = " + updatedPassport.getPlace() + " WHERE (`person_id` = " + updatedPassport.getPassportId() + ")";
        MysqlUtil.executeSqlQuery(sql);
    }

    @Override
    public void deletePassportById(long deletedId) {
        String sql = "DELETE FROM `my_crud_database`.`passport` WHERE (`passportId` = '" + deletedId + "')";
        MysqlUtil.executeSqlQuery(sql);
    }

    @Override
    public List<Passport> readAllPassports() {
        String sql = "SELECT * FROM my_crud_database.passport";
        ArrayList<Passport> passportList = MysqlUtil.executeSqlReadQuery(sql, new ResultSetPassportParser());
        return passportList;
    }


}
