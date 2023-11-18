package com.example.PizzaShop.models;

import jakarta.persistence.*;

@Entity
@Table(name = "ORDER_ITEMS")
public class OrderItems {
    @EmbeddedId
    private OrderProductKey orderProductKey;
    @ManyToOne
    @MapsId("order_id")
    @JoinColumn(name = "order_id")
    private CustomerOrder customerOrder;

    @ManyToOne
    @MapsId("product_id")
    @JoinColumn(name = "product_id")
    private Product product;
    @Column(name = "QUANTITY")
    private int quantity;


    public OrderItems() {
        super();
    }

    public OrderItems(OrderProductKey key, int quantity, CustomerOrder customerOrder, Product product) {
        super();
        this.orderProductKey = key;
        this.quantity = quantity;
        this.customerOrder = customerOrder;
        this.product = product;
    }

    //Getter
    public int getQuantity() {
        return this.quantity;
    }

    public Product getProduct() {
        return product;
    }

    //Setter
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setOrderProductKey(OrderProductKey orderProductKey) {
        this.orderProductKey = orderProductKey;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public void setCustomerOrder(CustomerOrder customerOrder) {
        this.customerOrder = customerOrder;
    }
}
