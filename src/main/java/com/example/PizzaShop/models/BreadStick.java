package com.example.PizzaShop.models;

import jakarta.persistence.*;
import net.snowflake.client.jdbc.internal.apache.tika.config.Field;

@Entity
@Table(name = "BREADSTICK")
public class BreadStick {
    @Id
    @Column(name = "PRODUCT_ID")
    private int product_id;

    @Column(name = "AMOUNT")
    private int amount;

    @Column(name = "PRICE")
    private double price;

    @OneToOne
    @JoinColumn(name = "product_id", referencedColumnName = "PRODUCT_ID")
    private Product product;

    public BreadStick(){super();}
    public BreadStick(int product_id, int amount, double price){
        super();
        this.product_id = product_id;
        this.amount=amount;
        this.price=price;
    }
    //Getters
    public int getId(){return this.product_id;}
    public int getAmount(){return this.amount;}
    public double getPrice(){return this.price;}
    public Product getProduct(){return this.product;}

    public void setPrice(double price) {
        this.price = price;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
