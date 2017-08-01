package com.prince.classroom.controllers;

import com.prince.classroom.data.StudentDAO;
import com.prince.classroom.models.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

/**
 * Created by davidprince on 7/31/17.
 */

@Controller
@RequestMapping("student")
public class StudentController {

    @Autowired
    StudentDAO studentDAO;


    @RequestMapping(value = "")
    public String index (Model model){
        model.addAttribute("students", studentDAO.findAll());
        model.addAttribute("title", "List Of All Students");

        return "student/index";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayAddStudentForm(Model model) {
        model.addAttribute("title", "Add Student");
        model.addAttribute(new Student());
        model.addAttribute("students", studentDAO.findAll());
        return "student/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processAddCheeseForm(@ModelAttribute @Valid Student newStudent,
                                       Errors errors, @RequestParam int classNumber, Model model) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Student");
            model.addAttribute("students", studentDAO.findAll());
            return "student/add";
        }
        studentDAO.save(newStudent);
        return "redirect:";
    }
}
