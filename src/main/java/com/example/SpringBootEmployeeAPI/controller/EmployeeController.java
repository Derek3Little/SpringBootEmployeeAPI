package com.example.SpringBootEmployeeAPI.controller;

import com.example.SpringBootEmployeeAPI.entity.Employee;
import com.example.SpringBootEmployeeAPI.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> findAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/employees/{id}") // passing {id} into findAnEmployee() via @PathVariable!
    public Employee findAnEmployee(@PathVariable int id) {
        return employeeService.getAnEmployee(id);
    }

    @PostMapping("/employees")
    public void createEmployee(@RequestBody Employee employee) {
        employeeService.createEmployee(employee);
    }

    @PutMapping("/employees/{id}")
    public void updateEmployee(@PathVariable int id, @RequestBody Employee employee) {
        employeeService.updateEmployee(employee);
    }

    @DeleteMapping("/employees/{id}")
    public List<Employee> deleteEmployee(@PathVariable int id) {
        employeeService.deleteEmployee(id);
        return employeeService.getAllEmployees(); // returning updated list to confirm deletion
    }
}
