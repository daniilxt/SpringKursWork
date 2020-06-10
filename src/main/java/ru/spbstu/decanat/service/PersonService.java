package ru.spbstu.decanat.service;

import ru.spbstu.decanat.entity.Person;

import java.util.List;

public interface PersonService {
    List<Person> listPerson();
    Person findPerson(Long id);
    Person addPerson(Person person);
    void deletePerson(Long id);
}