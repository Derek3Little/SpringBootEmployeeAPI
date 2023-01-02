package com.example.SpringBootEmployeeAPI;

import com.example.SpringBootEmployeeAPI.entity.Address;
import com.example.SpringBootEmployeeAPI.entity.Employee;
import com.example.SpringBootEmployeeAPI.entity.Project;
import com.example.SpringBootEmployeeAPI.entity.Spouse;
import com.example.SpringBootEmployeeAPI.service.EmployeeService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBootEmployeeApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootEmployeeApiApplication.class, args);
	}

	@Bean
	public CommandLineRunner initialCreate(EmployeeService employeeService) {
		return (args) -> {

			Address testAddress1 = new Address("testLine1","testLine2","testZip",
					"testCity", "testState", "testCountry");
			Project testProject1 = new Project("testProject", "testClient");
			Spouse testSpouse1 = new Spouse("testSpouseName", "testSpouseMobile", 36);

			Employee testEmployee = new Employee("testEmployeeName", "testEmployeeCity");
			testEmployee.addProject(testProject1);
			testEmployee.addAddress(testAddress1);
			testEmployee.setSpouse(testSpouse1);

			employeeService.createEmployee(testEmployee);

			System.out.println("Getting an employee");
			Employee employee1 = employeeService.getAnEmployee(1);
		};
	}

}
