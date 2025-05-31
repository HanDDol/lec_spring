package kr.nowsys.student_tracker;

import kr.nowsys.student_tracker.dao.StudentDao;
import kr.nowsys.student_tracker.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class StudentTrackerApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudentTrackerApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(StudentDao studentDao) {
        return args -> {
            createStudent(studentDao);
        };
    }

    void createStudent(StudentDao studentDao) {

        Student s = new Student("S B.", "Han", "exm@example.org");
        System.out.println("Create Student : " + s);

        studentDao.save(s);
        System.out.println("Saved Student : " + s);


    }
}
