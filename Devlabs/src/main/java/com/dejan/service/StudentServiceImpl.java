package com.dejan.service;

import com.dejan.entity.Student;
import com.dejan.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@EnableWebMvc
@Configuration
@ComponentScan
@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private  StudentRepository repository;

    public StudentServiceImpl() {
        this.repository = repository;
    }



    @Override
    public List<Student> getAllStudents() {
        List<Student> result = (List<Student>) repository.findAll();

        if (result.size() >= 1) {
            return result;
        } else {
            return new ArrayList<>();
        }
    }

    @Override
    public Student getStudentById(Long id) throws Exception {
        Optional<Student> student = repository.findById(id);

        if (student.isPresent()) return student.get();
        else {
            throw new Exception("No employee record exist for given id");
        }
    }

    @Override
    public Student createOrUpdateStudent(Student sudent) {
        if (sudent.getId() == null) {

            sudent = repository.save(sudent);

            return sudent;
        } else {
            Optional<Student> student = repository.findById(sudent.getId());

            if (student.isPresent()) {
                Student newStudent = student.get();
                newStudent.setUserName(sudent.getUserName());
                newStudent.setSurname(sudent.getSurname());
                newStudent.setAge(sudent.getAge());
                newStudent.setHeight(sudent.getHeight());
                newStudent.setStdyear(sudent.getStdyear());

                newStudent = repository.save(newStudent);

                return newStudent;
            } else {
                sudent = repository.save(sudent);

                return sudent;
            }
        }
    }

    @Override
    public void deleteStudentById(Long id) throws Exception {
        {
            Optional<Student> employee = repository.findById(id);

            if (employee.isPresent()) {
                repository.deleteById(id);
            } else {
                throw new Exception("No employee record exist for given id");
            }
        }
        }
}



