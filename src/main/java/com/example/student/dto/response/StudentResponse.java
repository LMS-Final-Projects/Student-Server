package com.example.student.dto.response;

import com.example.student.entity.Student;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class StudentResponse {

    private UUID id;
    private String studentName;
    private Integer year;
    private Integer studentNumber;
    private String email;
    private String phNumber;

    public StudentResponse(Student student) {
        this.id = student.getId();
        this.studentName = student.getStudentName();
        this.year = student.getYear();
        this.studentNumber = student.getStudentNumber();
        this.email = student.getEmail();
        this.phNumber = student.getPhNumber();
    }

}
