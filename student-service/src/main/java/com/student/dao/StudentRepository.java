package com.student.dao;

import com.student.model.StudentResponse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<StudentResponse, Long> {
}
