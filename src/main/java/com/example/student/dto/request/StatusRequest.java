package com.example.student.dto.request;


import com.example.student.entity.Student;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StatusRequest {
    private String id;
    private String status;
    public Student toEntity(){
        return Student.builder()
                .id(id)
                .status(status)
                .build();
    }
}
