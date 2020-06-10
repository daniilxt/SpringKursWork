package ru.spbstu.decanat.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.spbstu.decanat.entity.Person;
import ru.spbstu.decanat.exception.PersonNotFoundException;
import ru.spbstu.decanat.repository.PersonRepository;
import ru.spbstu.decanat.service.PersonService;

import java.util.List;
import java.util.Optional;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Override
    public List<Person> listPerson() {
        return (List<Person>) personRepository.findAll();
    }

    @Override
    public Person findPerson(Long id) {
        Optional<Person> optPerson = personRepository.findById(id);
        if (optPerson.isPresent()) {
            return optPerson.get();
        } else {
            throw new PersonNotFoundException("Person not found");
        }
    }

    @Override
    public Person addPerson(Person Person) {
        return personRepository.save(Person);
    }

    @Override
    public void deletePerson(Long id) {
        personRepository.deleteById(id);
    }
}