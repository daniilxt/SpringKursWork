package ru.spbstu.decanat.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import ru.spbstu.decanat.entity.Mark;
import ru.spbstu.decanat.entity.Subject;
import ru.spbstu.decanat.exception.SubjectNotFoundException;
import ru.spbstu.decanat.repository.MarkRepository;
import ru.spbstu.decanat.repository.SubjectRepository;
import ru.spbstu.decanat.service.SubjectService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/subjects")
public class SubjectController {
    private SubjectService subjectService;
    private MarkRepository markRepository;

    @Autowired
    public void setSubjectsService(SubjectService subjectsService) {
        this.subjectService = subjectsService;
    }

    @PostMapping(value = "/add", consumes = "application/json", produces = "application/json")
    public Subject addSubjects(@RequestBody Subject newSubject) {
        return subjectService.addSubjects(newSubject);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Subject>> getAllSubjects() {
        List<Subject> list = subjectService.listSubjects();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Subject> getSubjects(@PathVariable("id") Long id) {
        try {
            return new ResponseEntity<>(subjectService.findSubjects(id), HttpStatus.OK);
        } catch (SubjectNotFoundException exception) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Subject not found");
        }
    }

    @DeleteMapping(value = "/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteMark(@PathVariable("id") Long id) {
        try {
            subjectService.deleteSubjects(id);
        } catch (EmptyResultDataAccessException exception) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, "Such subject is related to mark");

        }
    }
}
