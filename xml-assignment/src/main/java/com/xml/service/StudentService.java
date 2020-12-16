package com.xml.service;

import com.xml.model.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {
    void createOrUpdateStudent(Student student );
    List<Student> getAllStudents();
    Student getStudentById( Long id );
    void deleteStudentById(Long id );
    List<Student> xmlAllStudents();
}
