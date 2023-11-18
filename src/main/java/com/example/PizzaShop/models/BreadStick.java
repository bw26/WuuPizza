package com.example.PizzaShop.models;

import jakarta.persistence.*;

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

    public BreadStick() {
        super();
    }

    public BreadStick(int product_id, int amount, double price, Product product) {
        super();
        this.product_id = product_id;
        this.amount = amount;
        this.price = price;
        this.product = product;
    }

    //Getters
    public int getId() {
        return this.product_id;
    }

    public int getAmount() {
        return this.amount;
    }

    public double getPrice() {
        return this.price;
    }

    public Product getProduct() {
        return this.product;
    }

    //Setter
    public void setPrice(double price) {
        this.price = price;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }
}
