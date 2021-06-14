package com.dejan.service;

import com.dejan.entity.Student;

import java.util.List;

public interface StudentService {

    public List<Student> getAllStudents();

    public Student getStudentById(Long id) throws Exception;

    public Student createOrUpdateStudent(Student sudent);


    public void deleteStudentById(Long id) throws Exception;

}
