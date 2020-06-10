package ru.spbstu.decanat.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Groups")
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(length = 50)
    @NotBlank(message = "Group name is required field")
    @Size(max = 50, message = "Group name cannot be longer than 50 symbols")
    private String name;

    public Group() {
    }

    public Group(@Size(max = 50, message = "Group name cannot be longer than 50 symbols") String name) {
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
        return "Group{" +
          "id=" + id +
          ", name='" + name + '\'' +
          '}';
    }
}