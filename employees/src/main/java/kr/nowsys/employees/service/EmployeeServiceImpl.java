package kr.nowsys.employees.service;

import jakarta.transaction.Transactional;
import kr.nowsys.employees.dao.EmployeeDao;
import kr.nowsys.employees.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    private EmployeeDao employeeDao;

    public EmployeeServiceImpl(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    @Override
    public List<Employee> findAll() {
        return this.employeeDao.findAll();
    }

    @Override
    public Employee findById(int id) {
        return this.employeeDao.findById(id);
    }

    @Override
    @Transactional
    public Employee save(Employee e) {
        return this.employeeDao.save(e);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        this.employeeDao.deleteById(id);
    }
}
