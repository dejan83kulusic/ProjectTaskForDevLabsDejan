package com.dejan.controller;

import com.dejan.entity.Student;
import com.dejan.repository.StudentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.List;


class StudentControllerTest {
    @Autowired
    StudentRepository repository;

    Student student1=new Student ();
    Student studen2=new Student ();

     List<Student> list= Arrays.asList (student1,studen2);
    @Test
    void deleteUser() {
        Student std1=repository.getById (student1.getId());
        Student std2=repository.getById (studen2.getId ());
        if(std1.equals (std2)) {
            list.remove (student1) ;
            System.out.println ("Test is pased");
        }else{
            System.out.println ("Test is not passes");
        }
    }
}