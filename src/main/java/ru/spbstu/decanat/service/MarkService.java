package ru.spbstu.decanat.service;


import ru.spbstu.decanat.entity.Mark;

import java.util.List;

public interface MarkService {
    void deleteMarks(Long id);
    List<Mark> listMarks();
    Mark findMarks(Long id);
    Mark addMarks(Mark marks);
}