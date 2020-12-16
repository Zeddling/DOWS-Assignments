package com.xmlrest.dao;

import com.xmlrest.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface XMLRepository extends JpaRepository<Student, Long> {
}
