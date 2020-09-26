package ru.spbstu.decanat.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import ru.spbstu.decanat.entity.Mark;
import ru.spbstu.decanat.exception.MarkNotFoundException;
import ru.spbstu.decanat.repository.PersonRepository;
import ru.spbstu.decanat.service.MarkService;

import java.util.List;

@RestController
@RequestMapping("/marks")
public class MarkController {
    private MarkService markService;
    private PersonRepository personRepository;
    private char STUDENT_TYPE = 'S';

    @Autowired
    public void setMarksService(MarkService markService) {
        this.markService = markService;
    }

    @PostMapping(value = "/add", consumes = "application/json", produces = "application/json")
    public Mark addMarks(@RequestBody Mark newMark) {
        return markService.addMarks(newMark);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Mark>> getAllMarks() {
        List<Mark> list = markService.listMarks();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Mark> getMarks(@PathVariable("id") Long id) {
        try {
            return new ResponseEntity<>(markService.findMarks(id), HttpStatus.OK);
        } catch (MarkNotFoundException exception) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Marks not found");
        }
    }

    @GetMapping("/student/{id}")
    public ResponseEntity<List<Mark>> getStudentMarks(@PathVariable long id) {
        List<Mark> list = markService.listMarksByStudentId(id);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteMark(@PathVariable("id") Long id) {
        try {
            markService.deleteMarks(id);
        } catch (EmptyResultDataAccessException exception) {

        }
    }
}

