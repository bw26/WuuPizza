package com.example.PizzaShop.models;

import jakarta.persistence.*;

@Entity
@Table(name = "ORDER_ITEMS")
@IdClass(OrderItems.class)
public class OrderItems {
    @Column(name = "QUANTITY")
    @Id
    private int quantity;

    @Column(name = "ORDER_ID")
    @Id
    private int order_id;
    @Column(name = "PRODUCT_ID")
    @Id
    private int product_id;

    public OrderItems(){super();}
    public OrderItems(int order_id, int product_id, int quantity){
        this.order_id=order_id;
        this.product_id=product_id;
        this.quantity=quantity;
    }

    public int getOrder_id() {
        return this.order_id;
    }

    public int getProduct_id() {
        return this.product_id;
    }

    public int getQuantity() {
        return this.quantity;
    }
}
