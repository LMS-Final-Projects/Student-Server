package com.example.student.servcie;


import com.example.global.exception.MethodException;
import com.example.global.exception.NotFoundException;
import com.example.student.dto.StudentDto;
import com.example.student.entity.Student;
import com.example.student.repository.StudentRepository;
import com.example.student.request.StudentRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository repository;

    //학생 회원가입 할때, 정보 저장.
    @Transactional
    public Void saveStudent(StudentRequest request){
        Student save = repository.save(request.toEntity());
       if (save == null) {
           throw new MethodException("회원가입 정보 저장 실패");
       }
        return null;
    }

    //학생 정보 찾기.
    public StudentDto findStudent(StudentRequest request) {

        Student student = repository.findByStudentId(request.getId()).get();
        if (student != null) {
            StudentDto dto = new StudentDto(student);
            return dto;
        }
        else throw new NotFoundException("해당 유저가 없습니다.");
    }


    //학생 정보 변경.
    public StudentDto updateStudent(StudentRequest request){
        Student student = repository.findByStudentId(request.getId()).get();
        if (student != null) {
            StudentDto dto = new StudentDto(request.toEntity());
            return dto;
        }
        else throw new NotFoundException("해당 유저가 없습니다.");
    }

}
