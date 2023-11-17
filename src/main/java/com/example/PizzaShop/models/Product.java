package com.example.PizzaShop.models;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "PRODUCT")
public class Product {
    @Column(name = "PRODUCT_ID")
    @Id
    private int product_id;

    @Column(name = "NAME")
    private String name;

    @ManyToMany(mappedBy = "products")
    private List<CustomerOrder> customerOrders;

    public Product(){super();}
    public Product(int product_id, String name){
        super();
        this.product_id = product_id;
        this.name=name;
    }
    //Getters
    public int getId(){return this.product_id;}
    public String getName(){return this.name;}


}
