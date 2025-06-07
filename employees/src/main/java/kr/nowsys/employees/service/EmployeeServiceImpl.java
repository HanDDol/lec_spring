package kr.nowsys.employees.service;

import jakarta.transaction.Transactional;
import kr.nowsys.employees.dao.EmployeeRepository;
import kr.nowsys.employees.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    private EmployeeRepository employeeDao;

    public EmployeeServiceImpl(EmployeeRepository employeeDao) {
        this.employeeDao = employeeDao;
    }

    @Override
    public List<Employee> findAll() {
        return this.employeeDao.findAll();
    }

    @Override
    public Employee findById(int id) {
        Optional<Employee> e = this.employeeDao.findById(id);
        if (e.isPresent())
            return e.get();
        else
            throw new RuntimeException("The Id does not exist - " + id);
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
