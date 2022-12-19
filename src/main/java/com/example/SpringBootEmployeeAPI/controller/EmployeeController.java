package com.example.SpringBootEmployeeAPI.controller;

import com.example.SpringBootEmployeeAPI.entity.Employee;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class EmployeeController {


    public List<Employee> findAllEmployees() {
        public List<Employee> employeeList = Arrays.asList(
                new Employee(1, "Derek", "Mystic"),
                new Employee(2, "Jess", "Mystic"),
                new Employee(3, "Smitty", "Memphis")
        );

        return employeeList;
    }
}
