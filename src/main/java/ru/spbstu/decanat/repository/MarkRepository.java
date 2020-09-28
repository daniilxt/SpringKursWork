package ru.spbstu.decanat.repository;

import org.springframework.data.repository.CrudRepository;
import ru.spbstu.decanat.entity.Mark;

public interface MarkRepository extends CrudRepository<Mark, Long> {
}