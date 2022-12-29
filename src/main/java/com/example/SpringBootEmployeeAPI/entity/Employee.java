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

    @OneToOne(cascade = CascadeType.ALL) // cascading ALL actions on employee to spouse, ie delete employee also deletes spouse
    @JoinColumn(name = "fk_spouse") // fk = foreign key
    private Spouse spouse;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Address> addresses; // one to many mapping reflects a single employee having multiple addresses

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "employee_project", // naming the table that stores the m2m relationship
        joinColumns = @JoinColumn(name = "fk_employee"), // naming the column that stores the employee id
        inverseJoinColumns = @JoinColumn(name = "fk_project")) // naming the column that stores the project id
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

    public void removeProject(Project project) { // method for removing a project from projects list
        this.projects.remove(project); // removal from project list here in Employee class
        project.getEmployees().remove(project); // removal of employee from employee list in Project class
    } // the bidirectional m2m mapping requires removal on both ends of the bidirectional relationship!

    public void addProject(Project project) { // as in removeProject, both ends of the removal must be accounted for!
        this.projects.add(project);
        project.getEmployees().add(this); // 'this' refers to 'project'
    }
}
