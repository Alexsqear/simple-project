package dev.alex.valentey.service;

import dev.alex.valentey.dao.PersonDao;
import dev.alex.valentey.dao.person.impl.PersonInMemoryDao;
import dev.alex.valentey.entity.Person;

import java.util.List;

public class PersonService {
    private PersonDao personDao = new PersonInMemoryDao();
//    private PersonDao personDao= new PersonMysqlJdbcDao();


    public List<Person> readAllPersons() {
        return personDao.readAllPersons();
    }


    public void createPerson(String createPersonIdParamString, String createPersonNameParamString, String createPersonAgeParamString) {
        long id = Long.parseLong(createPersonIdParamString);
        int age = Integer.parseInt(createPersonAgeParamString);
        Person person = new Person(id, createPersonNameParamString, age);
        personDao.createNewPerson(person);
    }

    public void deletePersonById(String deleteIdParam) {
        long id = Long.parseLong(deleteIdParam);
        personDao.deletePersonById(id);
    }

    public Person getPersonById(String updateIdParam) {
        long id = Long.parseLong(updateIdParam);
        return personDao.readPersonById(id);

    }

    public void updatePerson(String personIdParam, String updatedPersonNameParam, String updatedPersonAgeParam) {
        long id = Long.parseLong(personIdParam);
        int age = Integer.parseInt(updatedPersonAgeParam);
        Person person = new Person(id, updatedPersonNameParam, age);
        personDao.updatePerson(person);

    }
}
