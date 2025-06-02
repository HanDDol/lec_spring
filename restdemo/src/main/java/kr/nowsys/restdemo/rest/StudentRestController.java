package kr.nowsys.restdemo.rest;

import jakarta.annotation.PostConstruct;
import kr.nowsys.restdemo.entity.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
class StudentRestController {
    private List<Student> students ;

    @PostConstruct
    public void loadData() {
        students = new ArrayList<>();

        students.add(new Student("First", "Lan"));
        students.add(new Student("Second", "Kim"));
        students.add(new Student("Third", "Kang"));
    }


    @ExceptionHandler
    public ResponseEntity<StudentErrorReponse> handleException(Exception ex) {
        StudentErrorReponse error = new StudentErrorReponse(
                HttpStatus.BAD_REQUEST.value(),
                ex.getMessage(),
                System.currentTimeMillis());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/students")
    public List<Student> getStudents() {
        return students;
    }

    @GetMapping("/students/{studentId}")
    public Student getStudents(@PathVariable int studentId) {
        if (studentId < 0 || studentId >= students.size()) {
            throw new StudentNotFoundException("Student Id not found - " + studentId);
        }
        return students.get(studentId);
    }

}
