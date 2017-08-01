package com.prince.classroom.controllers;

import com.prince.classroom.data.ClassroomDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by davidprince on 8/1/17.
 */
@Controller
@RequestMapping
public class ClassroomController {

    @Autowired
    private ClassroomDAO classroomDAO;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String index(Model model, @RequestParam(defaultValue = "0") int id) {
        model.addAttribute("title", "Classrooms");
        model.addAttribute("classrooms", classroomDAO.findAll());
        return "classroom/index";
    }
}
