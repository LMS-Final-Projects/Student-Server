package com.example.student.controller;



import com.example.student.dto.request.StudentRequest;
import com.example.student.dto.response.StudentResponse;
import com.example.student.global.response.LmsResponse;
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


    //학생 정보 찾기.
    @GetMapping("/info")
    public LmsResponse<StudentResponse> findStudent(@RequestBody StudentRequest request) {
        StudentResponse student = studentService.findStudent(request);
        return new LmsResponse<>(HttpStatus.OK, student, "서비스 성공", "", LocalDateTime.now());
    }


    //학생 정보 변경
    @PostMapping("/info")
    public LmsResponse<StudentResponse> updateStudent(@RequestBody StudentRequest request){
        StudentResponse studentResponse = studentService.updateStudent(request);
        return new LmsResponse<>(HttpStatus.OK, studentResponse, "서비스 성공", "", LocalDateTime.now());
    }

}
