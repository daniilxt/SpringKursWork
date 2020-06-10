package ru.spbstu.decanat.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.spbstu.decanat.entity.Subject;
import ru.spbstu.decanat.exception.SubjectNotFoundException;
import ru.spbstu.decanat.repository.SubjectRepository;
import ru.spbstu.decanat.service.SubjectService;


import java.util.List;
import java.util.Optional;

@Service
public class SubjectServiceImpl implements SubjectService {

    @Autowired
    private SubjectRepository subRepository;

    @Override
    public List<Subject> listSubjects() {
        return (List<Subject>) subRepository.findAll();
    }

    @Override
    public Subject findSubjects(Long id) {
        Optional<Subject> optSubject = subRepository.findById(id);
        if (optSubject.isPresent()) {
            return optSubject.get();
        } else {
            throw new SubjectNotFoundException("Subject not found");
        }
    }

    @Override
    public Subject addSubjects(Subject Subject) {
        return subRepository.save(Subject);
    }

    @Override
    public void deleteSubjects(Long id) {
        subRepository.deleteById(id);
    }
}