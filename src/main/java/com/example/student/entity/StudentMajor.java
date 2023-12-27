package com.example.student.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StudentMajor {

    @Id
    private String id;
    @Column(nullable = false)
    private String studentId;
    @Column(nullable = false)
    private String checkMajor;
    @Column(nullable = false)
    private String majorName;



}
