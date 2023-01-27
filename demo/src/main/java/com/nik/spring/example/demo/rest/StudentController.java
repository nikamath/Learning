package com.nik.spring.example.demo.rest;

import com.nik.spring.example.demo.model.Student;
import com.nik.spring.example.demo.service.StudentService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/v1/student", produces = {MediaType.APPLICATION_JSON_VALUE})
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable("id") Long id) {
        return studentService.findStudentById(id);
    }

    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.findAllStudents();
    }

}
