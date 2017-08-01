package com.prince.classroom.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedEntityGraph;
import javax.validation.constraints.NotNull;

/**
 * Created by davidprince on 7/31/17.
 */

@Entity
public class Student {

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    private String firstName;

    @NotNull
    private String lastname;

    @NotNull
    //used numbers to identify classrooms, but this is arbitrary. The number isn't used for calculations.
    private String classNumber;

    @NotNull
    //Student ID is assigned by institution
    private String studentID;

    //default constructor
    public Student() {
    }

    public Student(int id, String firstName, String lastname, String classNumber, String studentID) {
        this.id = id;
        this.firstName = firstName;
        this.lastname = lastname;
        this.classNumber = classNumber;
        this.studentID = studentID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getClassNumber() {
        return classNumber;
    }

    public void setClassNumber(String classNumber) {
        this.classNumber = classNumber;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }
}
