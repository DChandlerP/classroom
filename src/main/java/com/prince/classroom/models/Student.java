package com.prince.classroom.models;

import javax.persistence.*;
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
    private String lastName;

    @ManyToOne
    private Classroom classroom;

    @NotNull
    //Student ID is assigned by institution
    private String studentID;

    //default constructor
    public Student() {
    }

    public Student(int id, String firstName, String lastName, Classroom classroom, String studentID) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.classroom = classroom;
        this.studentID = studentID;
    }

    @Override
    public String toString() {
        return  firstName  + " " +
                lastName + " | " + "Class: " +
                classroom.getName() + " | "+ "Student ID: " +
                studentID ;
    }

    public int getId() {
        return id;
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

    public Classroom getClassroom() {
        return classroom;
    }

    public void setClassroom(Classroom classroom) {
        this.classroom = classroom;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }
}
