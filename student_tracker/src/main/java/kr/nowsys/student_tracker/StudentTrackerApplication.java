package kr.nowsys.student_tracker;

import kr.nowsys.student_tracker.dao.StudentDao;
import kr.nowsys.student_tracker.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class StudentTrackerApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudentTrackerApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(StudentDao studentDao) {
        return args -> {
            // createStudent(studentDao);
            showAllStudents(studentDao);
        };
    }

    void createStudent(StudentDao studentDao) {

        Student s = new Student("S B.", "Han", "exm@example.org");
        System.out.println("Create Student : " + s);

        studentDao.save(s);
        System.out.println("Saved Student : " + s);

        Student rS = studentDao.findById(s.getId());
        System.out.println("Read Student : " + rS);

    }

    void showAllStudents(StudentDao studentDao) {
        List<Student> students = studentDao.findAll();

        for( Student s : students ) {
            System.out.println("Student : " + s);
        }
    }
}
