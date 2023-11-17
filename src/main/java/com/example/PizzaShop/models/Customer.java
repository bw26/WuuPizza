package com.example.PizzaShop.models;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "CUSTOMER")
public class Customer {
    @Column(name = "PHONE_NUMBER")
    @Id
    private Long phone_number;
    @Column(name = "STREET_ADDRESS")
    private String street_address;
    @Column(name = "ZIP_CODE")
    private int zip_code;
    @Column(name = "STATE")
    private String state;
    @Column(name = "CITY")
    private String city;

    @ManyToMany
    @JoinTable(
            name = "CUSTOMERORDER",
            joinColumns = @JoinColumn(name = "phone_number"),
            inverseJoinColumns = @JoinColumn(name = "employee_id"))
    private List<Employee> employees;

    public Customer(){super();}
    public Customer(Long phone_number, String street_address, int zip_code){
        super();
        this.phone_number=phone_number;
        this.street_address=street_address;
        this.zip_code=zip_code;
        this.state="";
        this.city="";
    }
    public Customer(Long phone_number, String street_address, int zip_code, String state, String city){
        this.phone_number=phone_number;
        this.street_address=street_address;
        this.zip_code=zip_code;
        this.state=state;
        this.city=city;
    }

    //Getters
    public Long getPhone_number(){return this.phone_number;}
    public String getStreet_address(){return this.street_address;}
    public int getZip_code(){return this.zip_code;}
    public String getState(){return this.state;}
    public String getCity(){return this.city;}


    public void setStreet_address(String street_address) {
        this.street_address = street_address;
    }

    public void setZip_code(int zip_code) {
        this.zip_code = zip_code;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setState(String state) {
        this.state = state;
    }
}
