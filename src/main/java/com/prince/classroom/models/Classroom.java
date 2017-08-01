package com.prince.classroom.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by davidprince on 8/1/17.
 */

@Entity
public class Classroom {

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    @Size(min=1, max=15)
    private String name;

    @OneToMany
    @JoinColumn(name = "classroom")
    private List<Student> Classes = new ArrayList<>();

    public Classroom() {
    }

    public Classroom(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Student> getClasses() {
        return Classes;
    }

}
