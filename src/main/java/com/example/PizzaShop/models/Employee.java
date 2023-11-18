package com.example.PizzaShop.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "EMPLOYEE")
public class Employee {
    @Column(name = "EMPLOYEE_ID")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int employee_id;
    @Column(name = "EMPLOYMENT_STATUS")
    private int employment_status;
    @Column(name = "EMPLOYEE_NAME")
    private String employee_name;
    @Column(name = "PASSWORD")
    private String password;
    @ManyToMany
    @JoinTable(name = "CUSTOMERORDER", joinColumns = @JoinColumn(name = "employee_id"), inverseJoinColumns = @JoinColumn(name = "phone_number"))
    private List<Customer> customers;

    public Employee() {
        super();
    }

    public Employee(int employee_id, int employment_status, String employee_name, String password, List<Customer> customers) {
        super();
        this.employee_id = employee_id;
        this.employment_status = employment_status;
        this.employee_name = employee_name;
        this.password = password;
        this.customers = customers;
    }

    //Getters
    public int getEmployee_id() {
        return this.employee_id;
    }

    public int getEmployment_status() {
        return this.employment_status;
    }

    public String getEmployee_name() {
        return this.employee_name;
    }

    public String getPassword() {
        return this.password;
    }

    //Setters
    public void setEmployee_name(String employee_name) {
        this.employee_name = employee_name;
    }

    public void setEmployment_status(int employment_status) {
        this.employment_status = employment_status;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
