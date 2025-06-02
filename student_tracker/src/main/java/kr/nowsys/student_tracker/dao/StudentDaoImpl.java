package kr.nowsys.student_tracker.dao;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import kr.nowsys.student_tracker.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class StudentDaoImpl implements StudentDao {
    private EntityManager em;

    @Autowired
    public StudentDaoImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    @Transactional
    public void save(Student theStudent) {
        em.persist(theStudent);
    }

    @Override
    public Student findById(int id) {
        return em.find(Student.class, id);
    }

    @Override
    public List<Student> findAll() {
        TypedQuery<Student> ss = em.createQuery("SELECT s FROM Student s ORDER BY s.lastName", Student.class);
        return ss.getResultList();
    }

    @Override
    @Transactional
    public void update(Student s) {
        em.merge(s);
    }
}
