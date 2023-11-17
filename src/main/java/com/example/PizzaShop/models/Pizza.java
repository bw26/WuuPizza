package com.example.PizzaShop.models;

import jakarta.persistence.*;
import net.snowflake.client.jdbc.internal.apache.tika.config.Field;

@Entity
@Table(name = "PIZZA")
public class Pizza {
    @Id
    @Column(name = "PRODUCT_ID")
    private int product_id;
    @Column(name = "TYPE")
    private String type;
    @Column(name = "SIZE")
    private int size;
    @Column(name = "PRICE")
    private double price;

    @OneToOne
    @JoinColumn(name = "product_id",referencedColumnName = "PRODUCT_ID")
    private Product product;

    public Pizza(){super();}
    public Pizza(int product_id, String type, int size, double price){
        super();
        this.product_id = product_id;
        this.type=type;
        this.size=size;
        this.price=price;
    }
    //Getters
    public int getId(){return this.product_id;}
    public String getType(){return this.type;}
    public int getSize(){return this.size;}
    public double getPrice(){return this.price;}
    public Product getProduct(){return this.product;}

    public void setPrice(double price) {
        this.price = price;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setType(String type) {
        this.type = type;
    }
}
