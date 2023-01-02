package com.example.SpringBootEmployeeAPI.service;

import com.example.SpringBootEmployeeAPI.entity.Address;
import com.example.SpringBootEmployeeAPI.entity.Employee;
import com.example.SpringBootEmployeeAPI.entity.Project;
import com.example.SpringBootEmployeeAPI.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

@Service
@Transactional
public class EmployeeService {

    List<Employee> employeeList = new ArrayList<>(Arrays.asList(

    ));

    @Autowired // spring automatically initializing
    EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees() {

        // return employeeList;

        return employeeRepository.findAll(); // JPA provides a findAll() method!
    }

    public Employee getAnEmployee(int id) {

        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("Employee not found!"));
        Set<Project> projects = employee.getProjects();

        System.out.println("Fetching projects in service class");
        for (Project p : projects) {
            System.out.println(p.getClientName());
        }

        return employee;
            // findById() provided by JPA, must throw an error if employee not found
    }

    public void createEmployee(Employee employee) {
        ArrayList<Address> addressArrayList = new ArrayList<>(); // empty arraylist for creation of employee addresses

        for (Address address : employee.getAddresses()) {
            addressArrayList.add((new Address(
                    address.getStreetLine1(),
                    address.getStreetLine2(),
                    address.getZipCode(),
                    address.getCity(),
                    address.getState(),
                    address.getCountry(),
                    employee)));
        }

        employee.setAddresses(addressArrayList);

        employeeRepository.save(employee); // JPA gives us the save method with the extension in EmployeeRepository!
    }

    public void updateEmployee(Employee employee) {
        /*

        List<Employee> tempEmployeeList = new ArrayList<>(); // temp list to replace perm list
        for (Employee emp : employeeList) { // loop through perm list to check for id match
            if (emp.getEmployeeId() == employee.getEmployeeId()) { // if match found..
                emp.setEmployeeName(employee.getEmployeeName()); // update
                emp.setEmployeeCity(employee.getEmployeeCity());
            }
            tempEmployeeList.add(emp); // add every employee to the temp list, including updated employee
        }
        this.employeeList = tempEmployeeList; // replace perm list with temp list

        */

        employeeRepository.save(employee);
    }

    public void deleteEmployee(int id) { // id of employee to be deleted
        /*

        List<Employee> tempEmployeeList = new ArrayList<>();
        for (Employee emp : employeeList) {
            if (emp.getEmployeeId() == id) {
                continue; // as updateEmployee, except skipping the matched id in the list reconstruction
            }
            tempEmployeeList.add(emp);
        }
        this.employeeList = tempEmployeeList;

        */

        employeeRepository.delete(employeeRepository.getReferenceById(id));
    }
}
