package dev.alex.valentey.dao;

import dev.alex.valentey.entity.Person;

import java.util.List;

public interface PersonDao {
    List<Person> readAllPersons();
    Person readPersonById(long personId);
    void createNewPerson(Person person);
    void updatePerson(Person updatedPerson);
    void deletePersonById(long deletedId);
}
