package ru.spbstu.decanat.repository;

import org.springframework.data.repository.CrudRepository;
import ru.spbstu.decanat.entity.Mark;
import ru.spbstu.decanat.entity.Person;
import ru.spbstu.decanat.entity.Subject;

import java.util.Optional;

public interface MarkRepository extends CrudRepository<Mark, Long> {
    Optional<Mark> findMarkByStudent(Long id);
    Optional<Mark> findMarkBySubject(Long id);

}