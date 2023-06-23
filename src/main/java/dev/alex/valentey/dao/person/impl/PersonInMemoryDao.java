package dev.alex.valentey.dao.person.impl;

import dev.alex.valentey.dao.PersonDao;
import dev.alex.valentey.entity.Person;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PersonInMemoryDao implements PersonDao {
    private static List<Person> personList = Stream.of(
            new Person(3, "dima", 25),
            new Person(4, "oleg", 27),
            new Person(5, "olga", 26)
    ).collect(Collectors.toList());


    @Override
    public List<Person> readAllPersons() {
        return personList;
    }

    @Override
    public Person readPersonById(long personId) {
        return personList.stream()
                .filter(currentPerson -> currentPerson.getPersonId() == personId)
                .findFirst()
                .orElse(new Person());
    }

    @Override
    public void createNewPerson(Person person) {
        personList.add(person);
    }

    @Override
    public void updatePerson(Person updatedPerson) {
        long personId = updatedPerson.getPersonId();
        Person person = readPersonById(personId);
        person.setName(updatedPerson.getName());
        person.setAge(updatedPerson.getAge());
    }

    @Override
    public void deletePersonById(long deletedId) {
        personList.removeIf(currentPerson -> currentPerson.getPersonId() == deletedId);
    }
}
