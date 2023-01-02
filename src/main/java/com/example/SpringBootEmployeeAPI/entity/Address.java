package com.example.SpringBootEmployeeAPI.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity // defining Address as an entity
@Table(name = "address") // naming the sql table
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String streetLine1;
    private String streetLine2;
    private String zipCode;
    private String city;
    private String state;
    private String country;

    @JsonIgnore
    @ManyToOne
    private Employee employee; // many to one mapping reflects multiple employees sharing a single address

    // full constructor with employee
    public Address(String streetLine1, String streetLine2, String zipCode, String city, String state, String country,
                   Employee employee) {
        this.streetLine1 = streetLine1;
        this.streetLine2 = streetLine2;
        this.zipCode = zipCode;
        this.city = city;
        this.state = state;
        this.country = country;
        this.employee = employee;
    }

    // full constructor minus employee
    public Address(String streetLine1, String streetLine2, String zipCode, String city, String state, String country) {
        this.streetLine1 = streetLine1;
        this.streetLine2 = streetLine2;
        this.zipCode = zipCode;
        this.city = city;
        this.state = state;
        this.country = country;
    }

    // empty default constructor
    public Address() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStreetLine1() {
        return streetLine1;
    }

    public void setStreetLine1(String streetLine1) {
        this.streetLine1 = streetLine1;
    }

    public String getStreetLine2() {
        return streetLine2;
    }

    public void setStreetLine2(String streetLine2) {
        this.streetLine2 = streetLine2;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
