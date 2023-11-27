package com.example.student.dto;

import com.example.student.entity.Student;
import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class StudentDto {

    private UUID id;
    private String studentName;
    private Integer year;
    private Integer studentNumber;
    private String email;
    private String phNumber;

    public StudentDto(Student student) {
        this.id = student.getId();
        this.studentName = student.getStudentName();
        this.year = student.getYear();
        this.studentNumber = student.getStudentNumber();
        this.email = student.getEmail();
        this.phNumber = student.getPhNumber();
    }
}
