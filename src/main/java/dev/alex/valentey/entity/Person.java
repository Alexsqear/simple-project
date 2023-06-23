package dev.alex.valentey.entity;

public class Person {
    private long personId;
    private String name;
    private int age;

    public Person(long personId, String name, int age) {
        this.personId = personId;
        this.name = name;
        this.age = age;
    }

    public Person( String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person() {
    }

    public long getPersonId() {
        return personId;
    }

    public void setPersonId(long personId) {
        this.personId = personId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "personId=" + personId +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
