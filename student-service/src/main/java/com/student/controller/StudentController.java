package com.student.controller;

import com.student.model.StudentRequest;
import com.student.model.StudentResponse;
import com.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class StudentController {

    @Autowired
    StudentService studentService;

    /*
     *  API requests
     */
    @PostMapping("add-student")
    public void saveStudent( @RequestBody StudentRequest studentRequest) {
        studentService.addStudent( studentRequest );
    }

    @PostMapping("update-student/{id}")
    public void updateStudent( @PathVariable("id") long id, @RequestBody StudentResponse studentResponse) {
        studentService.updateStudent( id, studentResponse );
    }

    @PostMapping(path = "csv-upload", consumes = "multipart/form-data")
    public boolean uploadCSVFile(@RequestParam("file") MultipartFile file) {
        if ( file.isEmpty() )
            return false;
        else
            return studentService.uploadCSVFile( file );
    }

    @GetMapping("fetch-all-students")
    public List<StudentResponse> fetchAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("get-student-by-id/{id}")
    public StudentResponse getStudentById( @PathVariable("id") long id ) {
        return studentService.getStudentById( id );
    }

    @GetMapping("delete-student-by-id/{id}")
    public void deleteStudent( @PathVariable("id") long id ) {
        studentService.deleteStudent( id );
    }

}
