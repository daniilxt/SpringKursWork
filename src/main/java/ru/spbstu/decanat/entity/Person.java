package ru.spbstu.decanat.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "People")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(length = 50)
    @NotBlank(message = "First name is required field")
    @Size(max = 50, message = "First name cant'be longer than 50 symbols")
    private String firstName;

    @Column(length = 50)
    @NotBlank(message = "Last name is required field")
    @Size(max = 50, message = "Last name cant'be longer than 50 symbols")
    private String lastName;

    @Column(length = 50)
    @NotBlank(message = "Middle name is required field")
    @Size(max = 50, message = "Middle name cant'be longer than 50 symbols")
    private String middleName;

    @ManyToOne(targetEntity = Group.class)
    private Group group;

    private char type;

    public Person() {
    }

    public Person(@NotBlank(message = "First name is required field") @Size(max = 50, message = "First name cant'be longer than 50 symbols") String firstName, @NotBlank(message = "Last name is required field") @Size(max = 50, message = "Last name cant'be longer than 50 symbols") String lastName, @NotBlank(message = "Middle name is required field") @Size(max = 50, message = "Middle name cant'be longer than 50 symbols") String middleName, Group group, char type) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.group = group;
        this.type = type;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public char getType() {
        return type;
    }

    public void setType(char type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Person{" +
          "id=" + id +
          ", firstName='" + firstName + '\'' +
          ", lastName='" + lastName + '\'' +
          ", middleName='" + middleName + '\'' +
          ", group=" + group +
          ", type=" + type +
          '}';
    }
}