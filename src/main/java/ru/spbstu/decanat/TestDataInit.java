package ru.spbstu.decanat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import ru.spbstu.decanat.entity.*;
import ru.spbstu.decanat.repository.*;

import java.util.Collections;

@Component
public class TestDataInit implements CommandLineRunner {

    @Autowired
    MarkRepository markRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    GroupRepository groupRepository;

    @Autowired
    PersonRepository personRepository;

    @Autowired
    SubjectRepository subjectRepository;

    @Autowired
    PasswordEncoder pwdEncoder;

    @Override
    public void run(String... args) throws Exception {
/*        Group firstGroup = new Group("STUDENTS");
        Group secondGroup = new Group("TEACHERS");
        groupRepository.save(firstGroup);
        groupRepository.save(secondGroup);
        Person stud1 = new Person("Egor", "Ivanov", "Anatolevich", firstGroup, 'S');
        Person stud2 = new Person("Oleg", "Sativa", "Og", firstGroup, 'S');
        Person teach1 = new Person("Elena", "Selivanova", "Olegovna", secondGroup, 'T');
        Person teach2 = new Person("Igor", "Vereninov", "Andreevich", secondGroup, 'T');
        personRepository.save(stud1);
        personRepository.save(stud2);
        personRepository.save(teach1);
        personRepository.save(teach2);

        Subject bio = new Subject("Biology");
        Subject oop = new Subject("OOP");
        subjectRepository.save(bio);
        subjectRepository.save(oop);

        markRepository.save(new Mark(stud1, bio, teach1, 5));
        markRepository.save(new Mark(stud2, bio, teach2, 2));
        markRepository.save(new Mark(stud2, bio, teach2, 5));*/
/*
        userRepository.save(new User("user", pwdEncoder.encode("pwd"), Collections.singletonList("ROLE_USER")));
        userRepository.save(new User("admin", pwdEncoder.encode("apwd"), Collections.singletonList("ROLE_ADMIN")));
*/
    }
}