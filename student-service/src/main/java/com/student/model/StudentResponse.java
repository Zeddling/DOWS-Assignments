package com.student.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Students")
public class StudentResponse implements Serializable {

    private static final long serialVersionUID = 8326543252923654291L;

    @Id
    @GeneratedValue( strategy = GenerationType.AUTO )
    private long id;

    private String studentName;
    private String studentDOB;
    private String studentEmail;
    private String studentZipCode;
    private String studentAddress;

    public StudentResponse() {
    }

    public StudentResponse(String studentName, String studentDOB,
                           String studentEmail, String studentZipCode, String studentAddress) {
        this.studentName = studentName;
        this.studentDOB = studentDOB;
        this.studentEmail = studentEmail;
        this.studentZipCode = studentZipCode;
        this.studentAddress = studentAddress;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentDOB() {
        return studentDOB;
    }

    public void setStudentDOB(String studentDOB) {
        this.studentDOB = studentDOB;
    }

    public String getStudentEmail() {
        return studentEmail;
    }

    public void setStudentEmail(String studentEmail) {
        this.studentEmail = studentEmail;
    }

    public String getStudentZipCode() {
        return studentZipCode;
    }

    public void setStudentZipCode(String studentZipCode) {
        this.studentZipCode = studentZipCode;
    }

    public String getStudentAddress() {
        return studentAddress;
    }

    public void setStudentAddress(String studentAddress) {
        this.studentAddress = studentAddress;
    }
}
