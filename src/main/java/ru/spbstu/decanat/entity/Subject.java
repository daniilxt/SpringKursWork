package ru.spbstu.decanat.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Subjects")
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(length = 50)
    @NotBlank(message = "Subject name is required field")
    @Size(max = 50, message = "Subject name can't be longer than 50 symbols")
    private String name;

    public Subject() {
    }

    public Subject(@NotBlank(message = "Subject name is required field") @Size(max = 50, message = "Subject name can't be longer than 50 symbols") String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Subject{" +
          "id=" + id +
          ", name='" + name + '\'' +
          '}';
    }
}