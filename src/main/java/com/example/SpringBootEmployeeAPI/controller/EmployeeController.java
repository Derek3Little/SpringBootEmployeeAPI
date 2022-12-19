package com.example.SpringBootEmployeeAPI.controller;

import com.example.SpringBootEmployeeAPI.entity.Employee;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class EmployeeController {

    @RequestMapping("/employees")
    public List<Employee> findAllEmployees() {
        List<Employee> employeeList = Arrays.asList(
                new Employee(1, "Derek", "Mystic"),
                new Employee(2, "Jess", "Mystic"),
                new Employee(3, "Smitty", "Memphis")
        );

        return employeeList;
    }
}
