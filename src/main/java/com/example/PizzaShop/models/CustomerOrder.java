package com.example.PizzaShop.models;

import jakarta.persistence.*;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

@Entity
@Table(name = "CUSTOMERORDER")
public class CustomerOrder {
    @Column(name = "ORDER_ID")
    @Id
    private int order_id;
    @Column(name = "EMPLOYEE_ID")
    private int employee_id;
    @Column(name = "PHONE_NUMBER")
    private Long phone_number;
    @Column(name = "DATE")
    @Temporal(TemporalType.DATE)
    Date date = new Date(System.currentTimeMillis());
    @Column(name = "TIME")
    @Temporal(TemporalType.TIME)
    Time time = new Time(this.date.getTime());
    @Column(name = "STATUS")
    private int status;

    @ManyToOne
    @MapsId("phone_number")
    @JoinColumn(name = "phone_number")
    private Customer customer;

    @ManyToOne
    @MapsId("employee_id")
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @OneToOne(mappedBy = "customerOrder")
    private OrderDetails orderDetails;

    @OneToMany(mappedBy = "customerOrder")
    private List<OrderItems> orderItems;

    public CustomerOrder() {
        super();
    }

    public CustomerOrder(int order_id, int employee_id, Long phone_number, Date date, Time time, int status, Customer customer, Employee employee, OrderDetails orderDetails, List<OrderItems> orderItems) {
        super();
        this.order_id = order_id;
        this.employee_id = employee_id;
        this.phone_number = phone_number;
        this.date = date;
        this.time = time;
        this.status = status;
        this.customer = customer;
        this.employee = employee;
        this.orderDetails = orderDetails;
        this.orderItems = orderItems;
    }

    //Getter
    public int getOrder_id() {
        return this.order_id;
    }

    public int getEmployee_id() {
        return this.employee_id;
    }

    public Long getPhone_number() {
        return this.phone_number;
    }

    public Date getDate() {
        return this.date;
    }

    public Time getTime() {
        return this.time;
    }

    public int getStatus() {
        return this.status;
    }

    public List<OrderItems> getOrderItems() {
        return orderItems;
    }

    public OrderDetails getOrderDetails() {
        return orderDetails;
    }

    //Setter
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

    public void setOrderItems(List<OrderItems> orderItems) {
        this.orderItems = orderItems;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public void setOrderDetails(OrderDetails orderDetails) {
        this.orderDetails = orderDetails;
    }
}
