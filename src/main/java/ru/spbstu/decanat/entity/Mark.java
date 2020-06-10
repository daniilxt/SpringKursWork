package ru.spbstu.decanat.entity;


import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "Marks")
public class Mark {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull(message = "Mark must have student id")
    @ManyToOne(targetEntity = Person.class)
    private Person student;

    @NotNull(message = "Mark must have subject id")
    @ManyToOne(targetEntity = Subject.class)
    private Subject subject;

    @NotNull(message = "Mark must have teacher id")
    @ManyToOne(targetEntity = Person.class)
    private Person teacher;

    @Column
    @NotNull(message = "Mark value may not be empty")
    private int value;

    public Mark() {
    }

    public Mark(Person student, Subject subject, Person teacher, int value) {
        this.student = student;
        this.subject = subject;
        this.teacher = teacher;
        this.value = value;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Person getStudent() {
        return student;
    }

    public void setStudent(Person student) {
        this.student = student;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public Person getTeacher() {
        return teacher;
    }

    public void setTeacher(Person teacher) {
        this.teacher = teacher;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Mark{" +
          "id=" + id +
          ", student=" + student +
          ", subject=" + subject +
          ", teacher=" + teacher +
          ", value=" + value +
          '}';
    }
}