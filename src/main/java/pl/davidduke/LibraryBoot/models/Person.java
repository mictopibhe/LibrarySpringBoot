package pl.davidduke.LibraryBoot.models;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Person")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @NotEmpty
    @Size(min = 2, max = 100, message = "The length of the name must be from 2 to 100 characters!")
    @Column(name = "name")
    private String name;

    @NotEmpty
    @Size(min = 2, max = 100, message = "The length of the surname must be from 2 to 100 characters!")
    @Column(name = "surname")
    private String surName;

    @Min(value = 1900, message = "Year of birth must be greater than 1900!")
    @Column(name = "birthyear")
    private int birthYear;

    public Person() {
        super();
    }

    public Person(int id, String name, String surName, int birthYear) {
        this.id = id;
        this.name = name;
        this.surName = surName;
        this.birthYear = birthYear;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }
}
