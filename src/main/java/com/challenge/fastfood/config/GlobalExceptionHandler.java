package com.challenge.fastfood.config;

import com.challenge.fastfood.config.exception.ClientAlreadyExistsException;
import com.challenge.fastfood.config.exception.ClientException;
import com.challenge.fastfood.config.exception.LunchItemException;
import org.springframework.http.*;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.Instant;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ClientException.class)
    ProblemDetail handleClientNotFoundException(ClientException e) {
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, e.getLocalizedMessage());
        problemDetail.setTitle(e.getMessage());
        problemDetail.setDetail("Client provided was not found in the database.");
        problemDetail.setProperty("TimeStamp", Instant.now());
        return problemDetail;
    }

    @ExceptionHandler(ClientAlreadyExistsException.class)
    ProblemDetail handleClientAlreadyExistsException(ClientAlreadyExistsException e) {
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, e.getLocalizedMessage());
        problemDetail.setTitle(e.getMessage());
        problemDetail.setDetail("This client is already registered.");
        problemDetail.setProperty("TimeStamp", Instant.now());
        return problemDetail;
    }

    @ExceptionHandler(LunchItemException.class)
    ProblemDetail handleLunchItemException(LunchItemException e) {
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, e.getLocalizedMessage());
        problemDetail.setTitle(e.getMessage());
        problemDetail.setDetail("Lunch item provided was not found in the database.");
        problemDetail.setProperty("TimeStamp", Instant.now());
        return problemDetail;
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        String detail = ex.getBindingResult().getAllErrors().stream()
                .map(ObjectError::getDefaultMessage)
                .collect(Collectors.joining(", "));
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, detail);
        problemDetail.setTitle("Validation Error");
        problemDetail.setProperty("TimeStamp", Instant.now());
        return new ResponseEntity<>(problemDetail, headers, status);
    }

}