package com.example.PizzaShop.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "PRODUCT")
public class Product {
    @Column(name = "PRODUCT_ID")
    @Id
    private int product_id;

    @Column(name = "NAME")
    private String name;


    @OneToMany(mappedBy = "product")
    private List<OrderItems> orderItems;

    public Product() {
        super();
    }

    public Product(int product_id, String name, List<OrderItems> orderItems) {
        super();
        this.product_id = product_id;
        this.name = name;
        this.orderItems = orderItems;
    }

    //Getters
    public int getId() {
        return this.product_id;
    }

    public String getName() {
        return this.name;
    }

    public int getProduct_id() {
        return product_id;
    }

    //Setter
    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOrderItems(List<OrderItems> orderItems) {
        this.orderItems = orderItems;
    }
}
