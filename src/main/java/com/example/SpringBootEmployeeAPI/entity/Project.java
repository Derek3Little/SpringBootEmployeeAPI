package com.example.SpringBootEmployeeAPI.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity // defining Project as an entity w/JPA
@Table(name = "project") // assigning table name in database w/JPA
public class Project {

    @Id // defining 'id' as the primary key w/JPA
    @GeneratedValue(strategy = GenerationType.IDENTITY) // JPA will automatically generate a new unique id
    private int id;

    private String name; // name of project
    private String clientName; // name of project's client

    @JsonIgnore // preventing endless looping due to m2m mapping
    @ManyToMany(mappedBy = "projects") // mappedBy referring to the 'projects' field in Employee class
    private List<Employee> employees; // list of employees working on this project

    public Project(String name, String clientName) {
        // this.id = id? not necessary due to JPA action in 'id' field above
        this.name = name;
        this.clientName = clientName;
    }

    public Project() {
        // empty default constructor
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
