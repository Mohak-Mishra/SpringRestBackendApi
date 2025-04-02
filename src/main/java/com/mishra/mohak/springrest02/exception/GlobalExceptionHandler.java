package com.mishra.mohak.springrest02.exception;

import com.mishra.mohak.springrest02.bean.Student;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = StudentNotFoundException.class )
    public MyErrorHandler studentNotFound(StudentNotFoundException e) {
        return new MyErrorHandler(LocalDateTime.now(),404,e.getMessage());
    }
}
