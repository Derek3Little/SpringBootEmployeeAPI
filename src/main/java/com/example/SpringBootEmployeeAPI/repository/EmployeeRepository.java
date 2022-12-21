package com.example.SpringBootEmployeeAPI.repository;

import com.example.SpringBootEmployeeAPI.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> { // <type (employee), primary key! (int)>

}
