package ru.spbstu.decanat.repository;

import org.springframework.data.repository.CrudRepository;
import ru.spbstu.decanat.entity.Group;

public interface GroupRepository extends CrudRepository<Group, Long> {
}