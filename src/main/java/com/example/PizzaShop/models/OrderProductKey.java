package com.example.PizzaShop.models;


import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class OrderProductKey implements Serializable {

    @Column(name = "order_id")
    private int order_id;
    @Column(name = "product_id")
    private int product_id;

    public OrderProductKey() {
    }

    public OrderProductKey(int order_id, int product_id) {
        super();
        this.order_id = order_id;
        this.product_id = product_id;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderProductKey orderProductKey = (OrderProductKey) o;
        return orderProductKey.getOrder_id() == this.order_id && orderProductKey.getProduct_id() == this.product_id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.order_id, this.product_id);
    }

    public int getProduct_id() {
        return product_id;
    }

    //Getter
    public int getOrder_id() {
        return order_id;
    }

    //Setter
    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }
}
