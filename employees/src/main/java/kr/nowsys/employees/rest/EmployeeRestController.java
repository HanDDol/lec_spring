package kr.nowsys.employees.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import kr.nowsys.employees.dao.EmployeeDao;
import kr.nowsys.employees.entity.Employee;
import kr.nowsys.employees.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    EmployeeService employeeService;
    ObjectMapper objectMapper;

    public EmployeeRestController(EmployeeService employeeService, ObjectMapper objectMapper) {
        this.employeeService = employeeService;
        this.objectMapper = objectMapper;
    }

    @GetMapping("/employees")
    public List<Employee> findAll() {
        return this.employeeService.findAll();
    }

    @GetMapping("/employees/{id}")
    public Employee findById(@PathVariable int id) {
        Employee e =  this.employeeService.findById(id);
        if ( e == null) {
            throw new RuntimeException("Employee is not found - " + id);
        }
        return e;
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee e) {
        e.setId(0);
        return this.employeeService.save(e);
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee e) {
        return this.employeeService.save(e);
    }

    @PutMapping("/employees/{id}")
    public Employee updateEmployeeWithId(@PathVariable int id, @RequestBody Employee e) {
        e.setId(id);
        return this.employeeService.save(e);
    }

    @DeleteMapping("/employees/{id}")
    public void removeEmployee(@PathVariable int id) {
        this.employeeService.deleteById(id);
    }

    @PatchMapping("/employees/{id}")
    public void patchEmployee(@PathVariable int id, @RequestBody Map<String, Object> patchMap) {
        Employee savedE = this.employeeService.findById(id);
        if ( savedE == null )
            throw new RuntimeException("No Such Employee - " + id);

        if ( patchMap.containsKey("id"))
            throw new RuntimeException("Id can't be changed - " + id);

        ObjectNode employeeNode = this.objectMapper.convertValue(savedE, ObjectNode.class);
        ObjectNode patchNode = this.objectMapper.convertValue(patchMap, ObjectNode.class);
        employeeNode.setAll(patchNode);
        Employee patchedE = this.objectMapper.convertValue(employeeNode, Employee.class);

        this.employeeService.save(patchedE);
    }
}
