package kr.nowsys.student_tracker.dao;

import kr.nowsys.student_tracker.entity.Student;

import java.util.List;

public interface StudentDao {
    void save(Student theStudent);

    Student findById(int id);

    List<Student> findAll();

    void update(Student s);

    void delete(int id);

    int deleteAll();
}
