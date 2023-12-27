package com.example.student.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Student {

    @Id
    private String id;
    @Column(nullable = false)
    private String studentName;
    @Column(nullable = false)
    private Integer year;
    @Column(nullable = false)
    private Integer studentNumber;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String phNumber;

    @Column(nullable = false)
    private String status;
    @Column(nullable = false)
    private String majorList;


    @Enumerated(EnumType.STRING)
    private Status status;


}

