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
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "order_id", referencedColumnName = "ORDER_ID")
    private CustomerOrder customerOrder;

    public OrderDetails() {
        super();
    }

    public OrderDetails(double price_charged, int order_id, CustomerOrder customerOrder) {
        this.price_charged = price_charged;
        this.order_id = order_id;
        this.customerOrder = customerOrder;
    }

    //Getter
    public double getPrice_charged() {
        return this.price_charged;
    }

    public int getOrder_id() {
        return this.order_id;
    }

    //Setter
    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public void setCustomerOrder(CustomerOrder customerOrder) {
        this.customerOrder = customerOrder;
    }

    public void setPrice_charged(double price_charged) {
        this.price_charged = price_charged;
    }
}
