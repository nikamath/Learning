package com.nik.spring.example.demo.service;

import com.nik.spring.example.demo.model.Student;
import com.nik.spring.example.demo.repository.StudentRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public Student findStudentById(Long id) {
        return studentRepository.getStudentById(id);
    }

    public List<Student> findAllStudents() {
        return studentRepository.getAllStudents();
    }
}
