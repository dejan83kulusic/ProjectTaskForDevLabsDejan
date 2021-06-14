package com.dejan.controller;
import com.dejan.entity.Student;
import com.dejan.service.StudentServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/")
public class StudentController {
    private final StudentServiceImpl service;

    public StudentController(StudentServiceImpl service) {
        this.service = service;
    }

    @RequestMapping
    public String getAllStudents(Model model)
    {
        List<Student> list =(List<Student>) service.getAllStudents();

        model.addAttribute("students", list);


        return "list-student";
    }

    @RequestMapping(path = {"/edit", "/edit/{id}"})
    public String getStudentById(Model model, @PathVariable("id") Optional<Long> id)
            throws Exception
    {
        if (id.isPresent()) {
            Student student = service.getStudentById(id.get());
            model.addAttribute("student", student);
        } else {
            model.addAttribute("student", new Student());
        }
        return "add-edit-student";
    }

    @RequestMapping(path = "/delete/{id}")
    public String deleteStudentById(Model model, @PathVariable("id") Long id)
            throws Exception
    {
        service.deleteStudentById(id);
        return "redirect:/";
    }

    @PostMapping( "/createStudent")
    public String createOrUpdateStudent(Student student)
    {
        service.createOrUpdateStudent(student);
        return "redirect:/";
    }

}
