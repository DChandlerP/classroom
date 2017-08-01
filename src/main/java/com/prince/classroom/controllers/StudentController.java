package com.prince.classroom.controllers;

import com.prince.classroom.data.StudentDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

/**
 * Created by davidprince on 7/31/17.
 */

@Controller
public class StudentController {

    @Autowired
    StudentDAO studentDAO;

    public String index (Model model){
        model.addAttribute("students", studentDAO.findAll());
        model.addAttribute("title", "List Of All Students");

        return "index";
    }
}
