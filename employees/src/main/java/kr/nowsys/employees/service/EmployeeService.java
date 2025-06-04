package kr.nowsys.employees.service;

import kr.nowsys.employees.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();
    Employee findById(int id);
    Employee save(Employee e);
    void deleteById(int id);

}
