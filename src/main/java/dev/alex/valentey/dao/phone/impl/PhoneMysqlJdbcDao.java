package dev.alex.valentey.dao.phone.impl;

import dev.alex.valentey.dao.PhoneDao;

import dev.alex.valentey.dao.util.MysqlUtil;

import dev.alex.valentey.entity.Phone;

import java.util.ArrayList;
import java.util.List;

public class PhoneMysqlJdbcDao implements PhoneDao {
    @Override
    public void createNewPhone(Phone phone) {
        String sql = String.format("INSERT INTO `my_crud_database`.`phone` (`countryCode`, `operatorCode`,`phoneNumber`) VALUES ('%s',%d,%d)",
                phone.getCountryCode(), phone.getOperatorCode(), phone.getPhoneNumber());
        MysqlUtil.executeSqlQuery(sql);
    }

    @Override
    public void updatePhone(Phone updatedPhone) {
        String sql = "UPDATE `my_crud_database`.`phone` SET `countryCode` = '" + updatedPhone.getCountryCode() + "'," +
                " `operatorCode` = " + updatedPhone.getOperatorCode() + "`phoneNumber` = " + updatedPhone.getPhoneNumber()
                + " WHERE (`phone_id` = " + updatedPhone.getPhoneId() + ")";
        MysqlUtil.executeSqlQuery(sql);
    }

    @Override
    public void deletePhoneById(long deletedId) {
        String sql = "DELETE FROM `my_crud_database`.`phone` WHERE (`phone_id` = '" + deletedId + "')";
        MysqlUtil.executeSqlQuery(sql);
    }

    @Override
    public List<Phone> readAllPhones() {
        String sql = "SELECT * FROM my_crud_database.phone";
        ArrayList<Phone> phoneList = MysqlUtil.executeSqlReadQuery(sql, new ResultSetPhoneParser());
        return phoneList;
    }

    @Override
    public Phone readPhoneById(long phoneId) {
        String sql = String.format("SELECT * FROM my_crud_database.phone where phone_id = %s", phoneId);
        ArrayList<Phone> phoneList = MysqlUtil.executeSqlReadQuery(sql, new ResultSetPhoneParser());
        if (!phoneList.isEmpty()) {
            return phoneList.get(0);
        }
        return new Phone();
    }
}
