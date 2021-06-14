package com.dejan.controller;

import com.dejan.entity.Student;
import com.dejan.repository.StudentRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@Controller

public class StudentController {

    private static StudentRepository studentRepository;

    public StudentController(StudentRepository studentRepository) {

        this.studentRepository = studentRepository;
    }




    @GetMapping("/edit")
    public String showSignUpForm(Student student) {
        return "add-student";
    }

    @PostMapping("/addstudent")
    public String addStudent(@Validated Student student, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-student";
        }

        studentRepository.save(student);
        return "redirect:/index";
    }
    @GetMapping("/index")
    public String showUserList(Model model) {
        model.addAttribute("students", studentRepository.findAll());
        return "index";
    }
    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") Long id, Model model) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));

        model.addAttribute("student", student);
        return "update-student";
    }
    @PostMapping("/update/{id}")
    public String updateUser(@PathVariable("id") Long id, @Validated Student student,
                             BindingResult result, Model model) {
        if (result.hasErrors()) {
            student.setId(id);
            return "update-student";
        }

        studentRepository.save(student);
        return "redirect:/index";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") long id, Model model) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        studentRepository.delete(student);
        return "redirect:/index";
    }
}