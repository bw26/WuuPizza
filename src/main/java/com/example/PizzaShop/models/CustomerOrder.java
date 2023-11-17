package com.example.PizzaShop.models;

import jakarta.persistence.*;
import jakarta.persistence.criteria.Order;

import java.sql.Time;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "CUSTOMERORDER")
public class CustomerOrder {
    @Column(name = "ORDER_ID")
    @Id
    @GeneratedValue
    private int order_id;
    @Column(name = "EMPLOYEE_ID")
    private int employee_id;
    @Column(name = "PHONE_NUMBER")
    private Long phone_number;
    @Column(name = "DATE")
    @Temporal(TemporalType.DATE)
    Date date;
    @Column(name = "TIME")
    @Temporal(TemporalType.TIME)
    Time time;
    @Column(name = "STATUS")
    private int status;

    @OneToOne(mappedBy = "customerOrder")
    private OrderDetails orderDetails;

    @ManyToMany
    @JoinTable(
            name = "ORDER_ITEMS",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id"))
    private List<Product> products;

    public CustomerOrder(){}
    public CustomerOrder(int order_id,int employee_id,Long phone_number,Date date,Time time,int status){
        this.order_id=order_id;
        this.employee_id=employee_id;
        this.phone_number=phone_number;
        this.date=date;
        this.time=time;
        this.status=status;
    }

    public int getOrder_id() {return this.order_id;}

    public int getEmployee_id() {return this.employee_id;}

    public Long getPhone_number() {return this.phone_number;}

    public Date getDate() {return this.date;}

    public Time getTime() {return this.time;}

    public int getStatus() {return this.status;}

    public List<Product> getProducts() {
        return products;
    }

    public OrderDetails getOrderDetails() {
        return orderDetails;
    }

    public void setPhone_number(Long phone_number) {
        this.phone_number = phone_number;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setEmployee_id(int employee_id) {
        this.employee_id = employee_id;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
