package com.example.student.controller;


import com.example.global.domain.response.LmsResponse;
import com.example.global.exception.NotFoundException;
import com.example.student.dto.StudentDto;
import com.example.student.entity.Student;
import com.example.student.request.StudentRequest;
import com.example.student.servcie.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/v1/student")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    //학생 정보 저장.
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public LmsResponse<Void> saveStudent(@RequestBody StudentRequest request){
        studentService.saveStudent(request);
        return new LmsResponse<>(HttpStatus.OK, null, "서비스 성공", "", LocalDateTime.now());
    }

    //학생 정보 찾기.
    @GetMapping("/info")
    public LmsResponse<StudentDto> findStudent(StudentRequest request) {
        StudentDto student = studentService.findStudent(request);
        return new LmsResponse<>(HttpStatus.OK, student, "서비스 성공", "", LocalDateTime.now());
    }


    //학생 정보 변경
    @PostMapping("/info")
    public LmsResponse<StudentDto> updateStudent(StudentRequest request){
        StudentDto studentDto = studentService.updateStudent(request);
        return new LmsResponse<>(HttpStatus.OK, studentDto, "서비스 성공", "", LocalDateTime.now());
    }

}
