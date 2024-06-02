package com.assignment.userpostservice.excepton;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(DownstreamException.class)
    public ResponseEntity<ErrorResponse> handleResourceNotFound(DownstreamException ex) {

        ErrorResponse errorResponse = new ErrorResponse(LocalDateTime.now().toString(),
                ex.getHttpStatus().value(), ex.getMessage(), null);
        return new ResponseEntity<>(errorResponse, ex.getHttpStatus());
    }

    @ExceptionHandler(AuthenticationException.class)
    public ResponseEntity<ErrorResponse> handleAuthenticationError(AuthenticationException ex) {

        ErrorResponse errorResponse = new ErrorResponse(LocalDateTime.now().toString(),
                HttpStatus.UNAUTHORIZED.value(), ex.getMessage(), null);
        return new ResponseEntity<>(errorResponse, HttpStatus.UNAUTHORIZED);
    }


}
