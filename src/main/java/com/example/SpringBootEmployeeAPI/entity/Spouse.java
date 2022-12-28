package com.example.SpringBootEmployeeAPI.entity;

import javax.persistence.*;

@Entity
@Table(name = "spouse")
public class Spouse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String mobileNumber;
    private int age;

    public Spouse(int id, String name, String mobileNumber, int age) {
        this.name = name;
        this.mobileNumber = mobileNumber;
        this.age = age;
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

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
