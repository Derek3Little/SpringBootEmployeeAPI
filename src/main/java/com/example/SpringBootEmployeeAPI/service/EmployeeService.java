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

    public void updateEmployee(Employee employee) {
        List<Employee> tempEmployeeList = new ArrayList<>(); // temp list to replace perm list
        for (Employee emp : employeeList) { // loop through perm list to check for id match
            if (emp.getEmployeeId() == employee.getEmployeeId()) { // if match found..
                emp.setEmployeeName(employee.getEmployeeName()); // update
                emp.setEmployeeCity(employee.getEmployeeCity());
            }
            tempEmployeeList.add(emp); // add every employee to the temp list, including updated employee
        }
        this.employeeList = tempEmployeeList; // replace perm list with temp list
    }
}
