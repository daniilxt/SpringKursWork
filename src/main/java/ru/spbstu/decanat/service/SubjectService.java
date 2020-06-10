package ru.spbstu.decanat.service;

import ru.spbstu.decanat.entity.Subject;

import java.util.List;

public interface SubjectService {
    List<Subject> listSubjects();
    Subject findSubjects(Long id);
    Subject addSubjects(Subject Subject);
    void deleteSubjects(Long id);
}