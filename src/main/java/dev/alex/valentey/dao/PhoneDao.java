package dev.alex.valentey.dao;

import dev.alex.valentey.entity.Person;
import dev.alex.valentey.entity.Phone;

import java.util.List;

public interface PhoneDao {
    List<Phone> readAllPhones();
    Phone readPhoneById(long phoneId);
    void createNewPhone(Phone phone);
    void updatePhone(Phone updatedPhone);
    void deletePhoneById(long deletedId);
}
