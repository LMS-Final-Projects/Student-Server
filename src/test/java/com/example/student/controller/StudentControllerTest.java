package com.example.student.controller;

import com.example.global.exception.MethodException;
import com.example.student.dto.request.StudentRequest;
import com.example.student.dto.response.StudentResponse;
import com.example.student.servcie.StudentService;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;
import java.util.UUID;

import static org.mockito.BDDMockito.*;
import static org.mockito.Mockito.doNothing;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(StudentController.class)
class StudentControllerTest {


    @Autowired
    MockMvc mockMvc;

    @MockBean
    StudentService studentService;

    @Autowired
    ObjectMapper objectMapper;

    @Nested
    class SaveStudent {

        @Test
        void success() throws Exception {
            // Given
            StudentRequest dto = new StudentRequest(UUID.randomUUID(), "채오성", 2023, 202317, "yrias8700@google.com", "010-6309-7402", List.of("math", "science"));

            // When
            doNothing().when(studentService).saveStudent(dto);

            // Then
            mockMvc.perform(post("/api/v1/student")
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(objectMapper.writeValueAsBytes(dto))
                    )
                    .andExpect(status().isCreated())
                    .andDo(print());
        }

        @Test
        void fail() throws Exception {
            // Given
            StudentRequest dto = new StudentRequest(UUID.randomUUID(), "채오성", 2023, 202317, "yrias8700@google.com", "010-6309-7402", List.of("math", "science"));

            // When
            doThrow(new MethodException("저장 기능 실패")).when(studentService).saveStudent(any(StudentRequest.class));

            // Then
            mockMvc.perform(post("/api/v1/student")
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(objectMapper.writeValueAsBytes(dto))
                    )
                    .andExpect(status().isInternalServerError())
                    .andDo(print());
        }
    }


    @Nested
    class findStudent {

        @Test
        void success() throws Exception {
            // Given
            StudentRequest dto = new StudentRequest(UUID.randomUUID(), "채오성", 2023, 202317, "yrias8700@google.com", "010-6309-7402", List.of("math", "science"));

            // Response
            StudentResponse res = new StudentResponse(dto.toEntity());

            // When
            given(studentService.findStudent(dto)).willReturn(res);

            // Then
            mockMvc.perform(get("/api/v1/student/info")
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(objectMapper.writeValueAsBytes(dto))
                    )
                    .andExpect(status().isOk())
                    .andDo(print());
        }

        @Test
        void fail() throws Exception {
            // Given
            StudentRequest dto = new StudentRequest(UUID.randomUUID(), "채오성", null, 202317, "yrias8700@google.com", "010-6309-7402", List.of("math", "science"));

            // When
            doThrow(new MethodException("찾기기능 실패")).when(studentService).findStudent(any(StudentRequest.class));

            // Then
            mockMvc.perform(get("/api/v1/student/info")
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(objectMapper.writeValueAsBytes(dto))
                    )
                    .andExpect(status().isBadRequest())
                    .andDo(print());
        }
    }

    @Nested
    class updateStudent {

        @Test
        void success() throws Exception {
            // Given
            StudentRequest dto = new StudentRequest(UUID.randomUUID(), "채오성", 2023, 202317, "yrias8700@google.com", "010-6309-7402", List.of("math", "science"));

            // Response
            StudentResponse res = new StudentResponse(dto.toEntity());

            // When
            given(studentService.updateStudent(dto)).willReturn(res);

            // Then
            mockMvc.perform(post("/api/v1/student/info")
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(objectMapper.writeValueAsBytes(dto))
                    )
                    .andExpect(status().isOk())
                    .andDo(print());
        }

        @Test
        void fail() throws Exception {
            // Given
            StudentRequest dto = new StudentRequest(UUID.randomUUID(), "채오성", 2023, 202317, "yrias8700@google.com", "010-6309-7402", List.of("math", "science"));

            // When
            doThrow(new MethodException("저장 기능 실패")).when(studentService).updateStudent(any(StudentRequest.class));

            // Then
            mockMvc.perform(post("/api/v1/student/info")
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(objectMapper.writeValueAsBytes(dto))
                    )
                    .andExpect(status().isInternalServerError())
                    .andDo(print());

        }
    }
}