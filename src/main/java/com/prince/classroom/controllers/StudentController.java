package com.prince.classroom.controllers;

import com.prince.classroom.data.ClassroomDAO;
import com.prince.classroom.data.StudentDAO;
import com.prince.classroom.models.Classroom;
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
import java.util.List;

/**
 * Created by davidprince on 7/31/17.
 */

@Controller
@RequestMapping("student")
public class StudentController {

    @Autowired
    StudentDAO studentDAO;

    @Autowired
    ClassroomDAO classroomDAO;


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
        model.addAttribute("classrooms", classroomDAO.findAll());
        return "student/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processAddCheeseForm(@ModelAttribute @Valid Student newStudent,
                                       Errors errors, @RequestParam int classroomId, Model model) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Student");
            model.addAttribute("students", studentDAO.findAll());
            return "student/add";
        }

        Classroom aClassroom = classroomDAO.findOne(classroomId);
        newStudent.setClassroom(aClassroom);
        studentDAO.save(newStudent);
        return "redirect:";
    }

    @RequestMapping(value = "remove", method = RequestMethod.GET)
    public String displayRemoveStudentForm(Model model) {
        model.addAttribute("students", studentDAO.findAll());
        model.addAttribute("title", "Remove Student");
        return "student/remove";
    }

    @RequestMapping(value = "remove", method = RequestMethod.POST)
    public String processRemoveStudentForm(@RequestParam int[] id) {

        for (int aid : id) {
            studentDAO.delete(aid);
        }

        return "redirect:";
    }

    @RequestMapping(value = "classroom", method = RequestMethod.GET)
    public String category(Model model, @RequestParam int id) {

        Classroom aClassroom = classroomDAO.findOne(id);
        List<Student> students= aClassroom.getClasses();
        model.addAttribute("students", students);
        model.addAttribute("title", "Students in Classroom: " + aClassroom.getName());
        return "student/index";
    }
}
