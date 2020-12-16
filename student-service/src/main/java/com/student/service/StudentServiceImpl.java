package com.student.service;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.student.dao.StudentRepository;
import com.student.model.CsvStudents;
import com.student.model.StudentRequest;
import com.student.model.StudentResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentRepository studentRepository;

    private static final Logger log = LoggerFactory.getLogger( StudentServiceImpl.class );

    @Override
    public void addStudent(StudentRequest studentRequest) {
        studentRepository.save( new StudentResponse( studentRequest.getStudentName(), studentRequest.getStudentDOB(),
                studentRequest.getStudentEmail(), studentRequest.getStudentZipCode(), studentRequest.getStudentAddress()));
    }

    @Override
    public void updateStudent(long id, StudentResponse studentResponse) {
        studentRepository.deleteById( id );
        studentRepository.save( studentResponse );
    }

    @Override
    public StudentResponse getStudentById(long id) {
        return studentRepository.findById( id ).orElseGet( StudentResponse::new );
    }

    @Override
    public List<StudentResponse> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public void deleteStudent(long id) {
        studentRepository.deleteById( id );
    }

    @Override
    public boolean uploadCSVFile(MultipartFile csvFile) {
        try (
                Reader reader = new BufferedReader( new InputStreamReader( csvFile.getInputStream() ))
        ){
            CsvToBean<CsvStudents> csvToBean = new CsvToBeanBuilder( reader )
                    .withType( CsvStudents.class )
                    .withIgnoreLeadingWhiteSpace( true )
                    .build();
            List<CsvStudents> studentsList = csvToBean.parse();

            for ( CsvStudents csvStudents : studentsList ) {
                studentRepository.save( new StudentResponse(
                        csvStudents.getStudentName(), csvStudents.getStudentDOB(), csvStudents.getStudentEmail(),
                        csvStudents.getStudentZipCode(), csvStudents.getStudentAddress()
                ) );
            }
            return true;

        } catch (IOException e) {
            return false;
        }
    }
}
