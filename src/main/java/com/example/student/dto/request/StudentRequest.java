package com.example.student.dto.request;


import com.example.student.entity.Status;
import com.example.student.entity.Student;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StudentRequest {
    private String id;
    private String studentName;
    private Integer year;
    private Integer studentNumber;
    private String email;
    private String phNumber;

    public Student toEntity(){
        return Student.builder()
                .id(id)
                .studentName(studentName)
                .year(year)
                .studentNumber(studentNumber)
                .email(email)
                .phNumber(phNumber)
                .status(Status.재학)
                .build();
    }
}
