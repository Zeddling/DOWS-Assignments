package com.view.dao;

import com.view.model.StudentRequest;
import com.view.model.StudentResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@FeignClient(name = "student-service")
public interface StudentProxy {

    /* *
     *      GET MAPPINGS
     */
    @GetMapping("/api/fetch-all-students")
    List<StudentResponse> fetchAllStudents();

    @GetMapping("/api/get-student-by-id/{id}")
    StudentResponse getStudentById( @PathVariable("id") long id );

    /* *
    *       POST MAPPINGS
    * */

    @PostMapping("/api/add-student")
    void addStudent(@RequestBody StudentRequest studentRequest);

    @PostMapping("/api/update-student/{id}")
    void updateStudent( @PathVariable("id") long id, @RequestBody StudentResponse studentResponse );

    @PostMapping( path = "/api/csv-upload", consumes = "multipart/form-data")
    boolean csvFileUpload( @RequestBody MultipartFile file );

    /* *
    *       DELETE MAPPINGS
     */

    @GetMapping("/api/delete-student-by-id/{id}")
    void deleteStudent( @PathVariable( "id" ) long id );

}
