package ru.spbstu.decanat.repository;

import org.springframework.data.repository.CrudRepository;
import ru.spbstu.decanat.entity.Person;

import java.util.Optional;

public interface PersonRepository extends CrudRepository<Person, Long> {
    Optional<Person> findPeopleByGroupId(Long id);
}