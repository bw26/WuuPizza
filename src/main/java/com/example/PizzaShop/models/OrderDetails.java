package com.example.PizzaShop.models;

import jakarta.persistence.*;

@Entity
@Table(name = "ORDERDETAILS")
public class OrderDetails {
    @Column(name = "PRICE_CHARGED")
    private double price_charged;
    @Column(name = "ORDER_ID")
    @Id
    private int order_id;
    @OneToOne
    @JoinColumn(referencedColumnName = "order_id")
    private CustomerOrder customerOrder;

    public OrderDetails(){super();}
    public OrderDetails(double price_charged, int order_id){
        this.price_charged=price_charged;
        this.order_id=order_id;
    }

    public double getPrice_charged() {return this.price_charged;}

    public int getOrder_id() {return this.order_id;}
}
