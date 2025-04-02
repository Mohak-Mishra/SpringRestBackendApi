package com.mishra.mohak.springrest02.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MyErrorHandler {
    private LocalDateTime timestamp;
    private Integer errorCode;
    private String errorMessage;
}
