package com.xml.controller;

import com.xml.model.Student;
import com.xml.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/")
public class StudentsController {

    @Autowired
    StudentService studentService;

    @RequestMapping(path = "/", produces = MediaType.APPLICATION_XML_VALUE)
    public String getAllStudents( Model model ) {
        List<Student> studentList = studentService.getAllStudents();
        model.addAttribute( "students", studentList );
        return "list-students";
    }

    @RequestMapping(path = {"/edit{id}"}, produces = MediaType.APPLICATION_XML_VALUE)
    public String editStudentsById( Model model, @PathVariable("id") Optional<Long> id ) {
        if ( id.isPresent() ) {
            Student student = studentService.getStudentById( id.get() );
            model.addAttribute( "student", student  );
        } else {
            model.addAttribute( "student", new Student() );
        }
        return "add-edit-student";
    }

    @RequestMapping(path = "/delete/{id}")
    public String deleteStudentById( Model model, @PathVariable("id") Long id ) {
        studentService.deleteStudentById( id );
        return "redirect:/";
    }

    @RequestMapping(path = "/create-student", method = RequestMethod.POST, produces = MediaType.APPLICATION_XML_VALUE)
    public String createOrUpdateStudent( Student student ) {
        studentService.createOrUpdateStudent( student );
        return "redirect:/";
    }

    @RequestMapping(path = "/expose-xml", produces = MediaType.APPLICATION_XML_VALUE)
    public List<Student> showXml() {
        return studentService.xmlAllStudents();
    }



}
