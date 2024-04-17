package com.tvtoner.cruddemo.entity;

import jakarta.persistence.*;

@Entity
@Table(name="Employees")
public class Employee {

    // define fields
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="Id")
    private int iD;

    @Column(name ="FirstName")
    private String firstName;

    @Column(name ="LastName")
    private String lastName;

    @Column(name ="Email")
    private String email;
    //define constructors

    public Employee(){

    }

    public Employee(int iD, String firstName, String lastName, String email) {
        this.iD = iD;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    //define getter/setter


    public int getiD() {
        return iD;
    }

    public void setiD(int iD) {
        this.iD = iD;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    //define toString

    @Override
    public String toString() {
        return "Employee{" +
                "iD=" + iD +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
