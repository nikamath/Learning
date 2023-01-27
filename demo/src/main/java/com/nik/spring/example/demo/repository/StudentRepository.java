package com.nik.spring.example.demo.repository;

import com.nik.spring.example.demo.model.Student;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class StudentRepository {
    Logger log = LoggerFactory.getLogger(StudentRepository.class);
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Student getStudentById(Long id) {
        log.debug("Getting student details for id: {}", id);
        Student student = jdbcTemplate.queryForObject("select id, name from student where id = ?", (rs, rowNum) -> new Student(rs.getLong("id"), rs.getString("name")), id);
        return student;
    }

    public List<Student> getAllStudents(){
        log.debug("Getting all students details");
        List<Student> students = jdbcTemplate.query("select id, name from student", (rs, rowNum) -> new Student(rs.getLong("id"), rs.getString("name")));
        return students;
    }
}
