package com.example.SpringBootEmployeeAPI.controller;

import com.example.SpringBootEmployeeAPI.entity.Employee;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class EmployeeController {
    public List<Employee> employeeList;

    public List<Employee> findAllEmployees() {
        return employeeList;
    }
}
