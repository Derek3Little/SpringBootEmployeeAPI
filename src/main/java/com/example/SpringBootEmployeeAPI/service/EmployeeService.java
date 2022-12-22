package com.example.SpringBootEmployeeAPI.service;

import com.example.SpringBootEmployeeAPI.entity.Employee;
import com.example.SpringBootEmployeeAPI.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class EmployeeService {

    List<Employee> employeeList = new ArrayList<>(Arrays.asList(

    ));

    @Autowired // spring automatically initializing
    EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees() {
        return employeeList;
    }

    public Employee getAnEmployee(int id) {
        return employeeList.stream().filter(e -> (e.getEmployeeId() == id)).findFirst().get();
    }

    public void createEmployee(Employee employee) {
        employeeRepository.save(employee); // JPA gives us the save method with the extension in EmployeeRepository!
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

    public void deleteEmployee(int id) { // id of employee to be deleted
        List<Employee> tempEmployeeList = new ArrayList<>();
        for (Employee emp : employeeList) {
            if (emp.getEmployeeId() == id) {
                continue; // as updateEmployee, except skipping the matched id in the list reconstruction
            }
            tempEmployeeList.add(emp);
        }
        this.employeeList = tempEmployeeList;
    }
}
