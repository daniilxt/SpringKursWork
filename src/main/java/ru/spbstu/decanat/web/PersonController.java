package ru.spbstu.decanat.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import ru.spbstu.decanat.entity.Mark;
import ru.spbstu.decanat.entity.Person;
import ru.spbstu.decanat.exception.PersonNotFoundException;
import ru.spbstu.decanat.repository.MarkRepository;
import ru.spbstu.decanat.service.PersonService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/person")
public class PersonController {
    private PersonService personService;
    private MarkRepository markRepository;

    @Autowired
    public void setPeopleService(PersonService personService) {
        this.personService = personService;
    }

   // @PostMapping(value = "/addPerson", consumes = "application/json", produces = "application/json")
    @PostMapping(value = "/add", consumes = "application/json", produces = "application/json")
    public Person addPerson(@RequestBody Person person) {
        return personService.addPerson(person);
    }

    //@GetMapping("/Person")
    @GetMapping("/all")
    public ResponseEntity<List<Person>> getAllPerson() {
        List<Person> list = personService.listPerson();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    //@GetMapping("/Person/{id}")
    @GetMapping("/id/{id}")
    public ResponseEntity<Person> getPerson(@PathVariable("id") Long id) {
        try {
            return new ResponseEntity<>(personService.findPerson(id), HttpStatus.OK);
        } catch (PersonNotFoundException exception) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Person not found");
        }
    }

    //@DeleteMapping(value = "/deletePerson/{id}")
    @DeleteMapping(value = "/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePerson(@PathVariable("id") Long id) {
        try {
            Optional<Mark> mark = markRepository.findMarkByStudent(id);
            if (mark.isPresent()) {
                throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, "Such person is related to mark");
            } else {
                personService.deletePerson(id);
            }
        } catch (EmptyResultDataAccessException exception) {

        }
    }
}

