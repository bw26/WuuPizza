package com.example.PizzaShop.models;

import jakarta.persistence.*;

import java.util.List;

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

    @OneToMany(mappedBy = "customer")
    private List<CustomerOrder> customerOrders;

    public Customer() {
        super();
    }

    public Customer(Long phone_number, String street_address, int zip_code, String state, String city, List<CustomerOrder> customerOrders) {
        super();
        this.phone_number = phone_number;
        this.street_address = street_address;
        this.zip_code = zip_code;
        this.state = state;
        this.city = city;
        this.customerOrders = customerOrders;
    }

    //Getters
    public Long getPhone_number() {
        return this.phone_number;
    }

    public String getStreet_address() {
        return this.street_address;
    }

    public int getZip_code() {
        return this.zip_code;
    }

    public String getState() {
        return this.state;
    }

    public String getCity() {
        return this.city;
    }

//    public List<CustomerOrder> getCustomerOrders() {
//        return customerOrders;
//    }

    //Setter
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

    public void setPhone_number(Long phone_number) {
        this.phone_number = phone_number;
    }
}
