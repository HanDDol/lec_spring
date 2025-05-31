package kr.nowsys.student_tracker.dao;
import jakarta.persistence.EntityManager;
import kr.nowsys.student_tracker.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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
}
