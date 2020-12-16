package com.xml.service;

import com.xml.dao.StudentRepository;
import com.xml.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentRepository repo;

    @Override
    public void createOrUpdateStudent(Student student) {
        if ( student.getId() == null ) // Student does not exist
        {
            repo.save(student);
        } else {
            Optional<Student> studentOptional = repo.findById( student.getId() );
            if ( studentOptional.isPresent() ) {   //  Update student
                Student newStudent = studentOptional.get();
                newStudent.setName( student.getName() );
                newStudent.setEmail( student.getEmail() );
                repo.save(newStudent);
            } else  //  Save if user does not exist
            {
                repo.save(student);
            }
        }
    }

    @Override
    public List<Student> getAllStudents() {
        List<Student> result = ( List<Student> ) repo.findAll();
        if ( !result.isEmpty() )    //  Not empty
            return result;
        else // if empty
            return new ArrayList<Student>();
    }

    @Override
    public Student getStudentById(Long id) {
        Optional<Student> studentOptional = repo.findById( id );
        return studentOptional.orElseGet(Student::new);
    }

    @Override
    public void deleteStudentById(Long id) {
        Optional<Student> studentOptional = repo.findById( id );
        if ( studentOptional.isPresent() ) {
            repo.deleteById( id );
        }
    }

    @Override
    public List<Student> xmlAllStudents() {
        return (List<Student>) repo.findAll();
    }
}
