package ru.spbstu.decanat.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import ru.spbstu.decanat.entity.Group;
import ru.spbstu.decanat.entity.Person;
import ru.spbstu.decanat.exception.GroupNotFoundException;
import ru.spbstu.decanat.repository.PersonRepository;
import ru.spbstu.decanat.service.GroupService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/groups")
public class GroupController {
    private GroupService groupService;
    private PersonRepository personRepository;

    @Autowired
    public void setGroupService(GroupService groupService) {
        this.groupService = groupService;
    }

    @PostMapping(value = "/add", consumes = "application/json", produces = "application/json")
    public Group addGroup(@RequestBody Group newGroup) {
        return groupService.addGroups(newGroup);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Group>> getAllGroups() {
        List<Group> list = groupService.listGroups();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }


    @GetMapping("/id/{id}")
    public ResponseEntity<Group> getGroup(@PathVariable("id") Long id) {
        try {
            return new ResponseEntity<>(groupService.findGroups(id), HttpStatus.OK);
        } catch (GroupNotFoundException exception) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Group not found");
        }
    }


    @DeleteMapping(value = "/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteGroup(@PathVariable("id") Long id) {
        try {
            Optional<Person> person = personRepository.findPeopleByGroupId(id);
            if (person.isPresent()) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "No");
            } else {
                groupService.deleteGroups(id);
                throw new ResponseStatusException(HttpStatus.OK, "OK");

            }
        } catch (EmptyResultDataAccessException exception) {

        }
    }
}
