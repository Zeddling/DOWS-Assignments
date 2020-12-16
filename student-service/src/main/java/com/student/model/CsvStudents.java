package com.student.model;

import com.opencsv.bean.CsvBindByName;

public class CsvStudents {

    @CsvBindByName(column = "name")
    private String studentName;

    @CsvBindByName(column = "dob")
    private String studentDOB;

    @CsvBindByName(column = "email")
    private String studentEmail;

    @CsvBindByName(column = "zipcode")
    private String studentZipCode;

    @CsvBindByName(column = "address")
    private String studentAddress;

    public CsvStudents() {
    }

    public CsvStudents(String studentName, String studentDOB, String studentEmail,
                       String studentZipCode, String studentAddress) {
        this.studentName = studentName;
        this.studentDOB = studentDOB;
        this.studentEmail = studentEmail;
        this.studentZipCode = studentZipCode;
        this.studentAddress = studentAddress;
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
