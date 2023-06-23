package dev.alex.valentey.dao;

import dev.alex.valentey.entity.Passport;
import dev.alex.valentey.entity.Person;

import java.util.List;

public interface PassportDao {
    List<Passport> readAllPassports();
    Passport readPassportById(long passportID);
    void createNewPassport(Passport passport);
    void updatePassport(Passport updatedPassport);
    void deletePassportById(long deletedId);
}
