package com.xmlrest.controller;

import com.xmlrest.dao.XMLRepository;
import com.xmlrest.model.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentRestController {
    private static final Logger log = LoggerFactory.getLogger(StudentRestController.class);
    @Autowired
    XMLRepository repo;

    @GetMapping(path = "/expose-xml", produces = MediaType.APPLICATION_XML_VALUE)
    public List<Student> getAllStudents(){
        List<Student> students = repo.findAll();
        log.info(students.toString());
        return repo.findAll();
    }
}
