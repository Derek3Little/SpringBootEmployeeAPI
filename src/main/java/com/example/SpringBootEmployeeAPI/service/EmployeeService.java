package com.example.SpringBootEmployeeAPI.service;

import com.example.SpringBootEmployeeAPI.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class EmployeeService {

    List<Employee> employeeList = new ArrayList<>(Arrays.asList(
            new Employee(1, "Derek", "Mystic"),
            new Employee(2, "Jess", "Mystic"),
            new Employee(3, "Smitty", "Memphis")
    ));

    public List<Employee> getAllEmployees() {
        return employeeList;
    }

    public Employee getAnEmployee(int id) {
        return employeeList.stream().filter(e -> (e.getEmployeeId() == id)).findFirst().get();
    }

    public void createEmployee(Employee employee) {
        employeeList.add(employee);
    }
}
