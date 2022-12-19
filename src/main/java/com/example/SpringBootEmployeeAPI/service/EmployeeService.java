package com.example.SpringBootEmployeeAPI.service;

import com.example.SpringBootEmployeeAPI.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class EmployeeService {

    List<Employee> employeeList = Arrays.asList(
            new Employee(1, "Derek", "Mystic"),
            new Employee(2, "Jess", "Mystic"),
            new Employee(3, "Smitty", "Memphis")
    );

    public List<Employee> getAllEmployees() {
        return employeeList;
    }
}
