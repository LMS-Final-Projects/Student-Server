package com.example.student.servcie;


import com.example.global.exception.MethodException;
import com.example.global.exception.NotFoundException;
import com.example.student.dto.request.StatusRequest;
import com.example.student.dto.response.StudentResponse;
import com.example.student.entity.Student;
import com.example.student.repository.StudentRepository;
import com.example.student.dto.request.StudentRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository repository;

    //학생 회원가입 할때, 정보 저장.
    @Transactional
    public void saveStudent(StudentRequest request) {

        try {
            repository.save(request.toEntity());
        } catch (Exception e) {
            throw new MethodException("회원가입 정보 저장 실패");
        }
    }

    //학생 정보 찾기.
    public StudentResponse findStudent(StudentRequest request) {

        Student student = repository.findByStudentId(request.getId()).orElseThrow(() -> new NotFoundException("해당 유저가 없습니다."));
        StudentResponse dto = new StudentResponse(student);
        return dto;
    }


    //학생 정보 변경.
    public StudentResponse updateStudent(StudentRequest request) {
        Student student = repository.findByStudentId(request.getId()).orElseThrow(() -> new NotFoundException("해당 유저가 없습니다."));
        repository.findByStudentId(request.getId());
        StudentResponse dto = new StudentResponse(student);
        return dto;
    }

    //학생 상태 변경
    public StudentResponse updateStatus(StatusRequest request) {
        Student student = repository.findByStudentId(request.getId()).orElseThrow(() -> new NotFoundException("해당 유저가 없습니다."));
        repository.findByStudentId(request.getId());
        StudentResponse dto = new StudentResponse(student);
        return dto;
    }


    //학생 전체 조회.
    public List<StudentResponse> getAll() {
        List<StudentResponse> dtoList = new ArrayList<>();
        try {
            List<Student> all = repository.findAll();

            for (Student student : all) {
                StudentResponse response = new StudentResponse(student);
                dtoList.add(response);
            }

            return dtoList;
        } catch (Exception e) {
            throw new MethodException("학생 조회 실패");
        }
    }
}
