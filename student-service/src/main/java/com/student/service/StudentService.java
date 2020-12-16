package com.student.service;

import com.student.model.StudentRequest;
import com.student.model.StudentResponse;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface StudentService {

    void addStudent(StudentRequest studentRequest);
    void updateStudent(long id, StudentResponse studentResponse);
    StudentResponse getStudentById(long id );
    List<StudentResponse> getAllStudents();
    void deleteStudent( long id );
    boolean uploadCSVFile( MultipartFile csvFile );
}
