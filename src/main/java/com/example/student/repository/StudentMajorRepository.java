package com.example.student.repository;


import com.example.student.entity.Student;
import com.example.student.entity.StudentMajor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface StudentMajorRepository extends JpaRepository<StudentMajor, String> {

}
