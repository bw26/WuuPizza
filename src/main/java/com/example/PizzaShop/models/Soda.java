package com.example.PizzaShop.models;

import jakarta.persistence.*;

@Entity
@Table(name = "SODA")
public class Soda {
    @Id
    @Column(name = "PRODUCT_ID")
    private int product_id;
    @Column(name = "SIZE")
    private int size;
    @Column(name = "PRICE")
    private double price;

    @OneToOne
    @JoinColumn(name = "product_id", referencedColumnName = "PRODUCT_ID")
    private Product product;

    public Soda() {
        super();
    }

    public Soda(int product_id, int size, double price, Product product) {
        super();
        this.product_id = product_id;
        this.size = size;
        this.price = price;
        this.product = product;
    }

    //Getters
    public int getId() {
        return this.product_id;
    }

    public int getSize() {
        return this.size;
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

    public void setSize(int size) {
        this.size = size;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
