package com.example.student.dto.request;

import com.example.student.entity.Status;
import com.example.student.entity.Student;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StatusRequest {

    private UUID id;
    private Status status;

    public Student toEntity(){
        return Student.builder()
                .id(id)
                .status(status)
                .build();
    }
}
