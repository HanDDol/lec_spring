package kr.nowsys.restdemo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class StudentNotFoundExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<StudentErrorReponse> handleStudentNotFoundException(StudentNotFoundException ex) {

        StudentErrorReponse error = new StudentErrorReponse(
                HttpStatus.NOT_FOUND.value(),
                ex.getMessage(),
                System.currentTimeMillis());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

}
