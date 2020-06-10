package ru.spbstu.decanat.repository;

import org.springframework.data.repository.CrudRepository;
import ru.spbstu.decanat.entity.Subject;

public interface SubjectRepository extends CrudRepository<Subject, Long> {
}