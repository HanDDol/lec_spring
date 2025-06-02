package kr.nowsys.restdemo.rest;

import jakarta.annotation.PostConstruct;
import kr.nowsys.restdemo.entity.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("/students")
    public List<Student> getStudents() {
        return students;
    }

    @GetMapping("/students/{studentId}")
    public Student getStudents(@PathVariable int studentId) {
        return students.get(studentId);
    }

}
