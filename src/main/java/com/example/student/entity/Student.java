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
public class Student {

    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String studentName;
    private Integer year;
    private Integer studentNumber;
    @Column(unique = true)
    private String email;
    @Column(unique = true)
    private String phNumber;

}

