package ru.spbstu.decanat.service;


import ru.spbstu.decanat.entity.Mark;

import java.util.List;

public interface MarkService {
    void deleteMarks(Long id);
    void deleteAllStudentMarks(Long id);
    List<Mark> listMarks();
    List<Mark> listMarksByStudentId(Long id);
    Mark findMarks(Long id);
    Mark addMarks(Mark marks);
}