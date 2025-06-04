package kr.nowsys.employees.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import kr.nowsys.employees.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDaoJapImpl implements EmployeeDao{

    private EntityManager em;

    @Autowired
    public EmployeeDaoJapImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<Employee> findAll() {
        TypedQuery<Employee> q = em.createQuery("SELECT e FROM Employee e", Employee.class);
        return q.getResultList();
    }

    @Override
    public Employee findById(int id) {
        Employee e = em.find(Employee.class, id);
        return e;
    }

    @Override
    public Employee save(Employee e) {
        Employee employee = em.merge(e);
        return employee;
    }

    @Override
    public void deleteById(int id) {
        Employee e = em.find(Employee.class, id);
        em.remove(e);
    }
}
