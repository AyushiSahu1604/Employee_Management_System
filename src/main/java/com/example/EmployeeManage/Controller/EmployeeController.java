package com.example.EmployeeManage.Controller;

import com.example.EmployeeManage.Entity.Employee;
import com.example.EmployeeManage.Service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employees")
@RequiredArgsConstructor
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/save-employee")
    public Employee createOrUpdateemployee(Employee employee){
        return employeeService.saveEmployee(employee);
    }

    @GetMapping("/get-employee")
    public List<Employee> getAllEmployees(){
        return employeeService.getAllEmployee();
    }

    @GetMapping("/get-employee-by-id/{id}")
    public Optional<Employee> getEmployeeById(@PathVariable Long id){
        return employeeService.getEmployeeById(id);
    }

    @DeleteMapping("/delete-employee-by-id/{id}")
    public String deleteEmployeeById(@PathVariable Long id){
        employeeService.deleteEmployeeById(id);
        return "Employee with Id "+id+" deleted.";
    }
}
