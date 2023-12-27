package com.example.student.global.kafka;


import com.example.student.entity.Student;
import com.example.student.entity.StudentMajor;
import com.example.student.repository.StudentMajorRepository;
import com.example.student.repository.StudentRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class KafkaConsumer {

    private final StudentMajorRepository studentMajorRepository;
    private final StudentRepository studentRepository;

    @KafkaListener(topics = "member", groupId = "student_1")
    public void studentListener(String kafkaMessage) {
        Map<Object, Object> map;
        ObjectMapper mapper = new ObjectMapper();
        try {
            map = mapper.readValue(kafkaMessage, new TypeReference<>() {});
            String action = (String) map.get("kafkaAction");
            if (action.equals(KafkaAction.CREATE.name())) {
                String role = (String) map.get("role");
                if ("STUDENT".equals(role)) {
                    Student save = Student.builder()
                            .id((String) map.get("id"))
                            .studentName((String) map.get("name"))
                            .studentNumber((Integer) map.get("studentNumber"))
                            .phNumber((String) map.get("phNumber"))
                            .email((String) map.get("email"))
                            .year((Integer) map.get("year"))
                            .majorList((String) map.get("majorList"))
                            .status((String) map.get("status"))
                            .build();
                    studentRepository.save(save);
                    System.out.println(map);
                } else {
                    System.out.println("Skipping Student save due to invalid role: " + map);
                }
            }
        } catch (JsonProcessingException ex) {
            ex.printStackTrace();
        }
    }

    @KafkaListener(topics = "major", groupId = "student_1")
    public void majorListener(String kafkaMessage) {
        Map<Object, Object> map;
        ObjectMapper mapper = new ObjectMapper();
        try {
            map = mapper.readValue(kafkaMessage, new TypeReference<>() {});
            String action = (String) map.get("kafkaAction");
            if (action.equals(KafkaAction.CREATE.name())) {
                String role = (String) map.get("role");
                if ("STUDENT".equals(role)) {
                    StudentMajor build = StudentMajor.builder()
                                .id((String) map.get("id"))
                                .studentId((String) map.get("memberId"))
                                .majorName((String) map.get("majorName"))
                                .checkMajor((String) map.get("checkMajor"))
                                .build();
                        studentMajorRepository.save(build);
                        System.out.println(map);
                } else {
                    System.out.println("Skipping Student save due to invalid role: " + map);
                }
            }
        } catch (JsonProcessingException ex) {
            ex.printStackTrace();
        }
    }

}

