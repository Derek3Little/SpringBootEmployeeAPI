package com.example.SpringBootEmployeeAPI.entity;

import javax.persistence.*;
import java.util.List;

@Entity // JPA
public class Employee {

    @Id // designated employeeId as the primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // automatically generating unique employeeId, no need to pass!
    int employeeId;

    String employeeName;
    String employeeCity;

    @OneToOne
    @JoinColumn(name = "fk_spouse") // fk = foreign key
    private Spouse spouse;

    @OneToMany
    private List<Address> addresses; // one to many mapping reflects a single employee having multiple addresses

    @ManyToMany
    private List<Project> projects; // many to many mapping reflects multiple employees working with multiple projects

    public Employee(int employeeId, String employeeName, String employeeCity) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.employeeCity = employeeCity;
    }

    public Employee() { // empty default constructor

    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeCity() {
        return employeeCity;
    }

    public void setEmployeeCity(String employeeCity) {
        this.employeeCity = employeeCity;
    }

    public Spouse getSpouse() {
        return spouse;
    }

    public void setSpouse(Spouse spouse) {
        this.spouse = spouse;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }
}
