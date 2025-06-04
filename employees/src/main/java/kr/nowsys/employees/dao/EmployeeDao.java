package kr.nowsys.employees.dao;

import kr.nowsys.employees.entity.Employee;

import java.util.List;

public interface EmployeeDao {

    List<Employee> findAll();

    Employee findById(int id);

    Employee save(Employee e);

    void deleteById(int id);
}
