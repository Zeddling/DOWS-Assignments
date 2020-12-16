package com.view.controller;

import com.view.dao.StudentProxy;
import com.view.model.StudentRequest;
import com.view.model.StudentResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/dashboard/")
public class ViewController {

    @Autowired
    StudentProxy studentProxy;

    @ModelAttribute("student")
    public StudentRequest studentRequest(){
        return new StudentRequest();
    }

    @ModelAttribute("studentUpdate")
    public StudentResponse studentResponse() {
        return new StudentResponse();
    }

    @GetMapping("home")
    public String homePage( Model model ) {
        model.addAttribute( "studentList", studentProxy.fetchAllStudents() );
        return "home";
    }

    @GetMapping("add-student")
    public String showCreateForm(  ) {
        return "student-editor";
    }

    @GetMapping("upload")
    public String showUploadPage() {
        return "upload";
    }

    @PostMapping(path="upload-students", consumes = "multipart/form-data")
    public String uploadMultipleStudents( @RequestParam("file") MultipartFile file ) {
        boolean status = studentProxy.csvFileUpload( file );
        if ( status )
            return "redirect:/dashboard/home?success";
        else
            return "redirect:/dashboard/upload?error";
    }

    @PostMapping("create-student")
    public String createStudent( @ModelAttribute("student") StudentRequest studentRequest) {
        studentProxy.addStudent(studentRequest);
        return "redirect:/dashboard/home?success";
    }

    @GetMapping("edit/{id}")
    public String showUpdateForm( @PathVariable("id") long id, Model model ) {
        StudentResponse studentResponse = studentProxy.getStudentById( id );
        studentResponse.setId( id );
        model.addAttribute( "student", studentResponse );
        return "student-editor-update";
    }

    @PostMapping("update/{id}")
    public String updateStudent( @PathVariable("id") long id, @ModelAttribute("studentUpdate")  StudentResponse studentResponse, Model model ) {
        studentProxy.updateStudent( id, studentResponse );
        return "redirect:/dashboard/home?success";
    }

    @GetMapping("delete/{id}")
    public String deleteStudent( @PathVariable("id") long id, Model model ) {
        studentProxy.deleteStudent( id );
        return "redirect:/dashboard/home?delete";
    }

}
