package com.example.student.controller;


import com.example.student.dto.request.StatusRequest;
import com.example.student.dto.response.StudentResponse;
import com.example.student.global.response.LmsResponse;
import com.example.student.servcie.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1/manager")
@RequiredArgsConstructor
public class ManagerController {

    private final StudentService studentService;


    //전체 학생 조회
    @GetMapping
    public LmsResponse<List<StudentResponse>> getAll(){

        List<StudentResponse> all = studentService.getAll();
        return new LmsResponse<>(HttpStatus.OK, all, "서비스 성공", "", LocalDateTime.now());
    };


    //학생 상태 관리
    @PostMapping("/status")
    public LmsResponse<StudentResponse> updateStatus(@RequestBody StatusRequest request){
        StudentResponse studentResponse = studentService.updateStatus(request);
        return new LmsResponse<>(HttpStatus.OK, studentResponse, "서비스 성공", "", LocalDateTime.now());

    }

}
