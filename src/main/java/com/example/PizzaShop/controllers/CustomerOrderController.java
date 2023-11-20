package com.example.PizzaShop.controllers;

import com.example.PizzaShop.models.CustomerOrder;
import com.example.PizzaShop.models.OrderItems;
import com.example.PizzaShop.repository.CustomerOrderRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.sql.Date;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api/v1")
public class CustomerOrderController {

    @Autowired
    private CustomerOrderRepo customerOrderRepo;

    @GetMapping("/orders")
    public List<CustomerOrder> findAll(@RequestParam(required = false) Long zip, @RequestParam(required = false)boolean byWeek) {
        if (zip != null){
            if (byWeek){
                return customerOrderRepo.findOrderByZipByWeek(zip);
            }
            return customerOrderRepo.findOrderByZip(zip);
        }
        return customerOrderRepo.findAll();
    }

    @GetMapping("/orders/{id}")
    public CustomerOrder findCustomerOrderById(@PathVariable Long id) {
        return customerOrderRepo.findCustomerOrderById(id);
    }

    @Transactional
    @PostMapping("/orders")
    public void addOrder(@Valid @RequestBody CustomerOrder customerOrder) {
        int order_id = customerOrderRepo.getLargestID() + 1;
        customerOrderRepo.saveOrder(order_id, customerOrder.getEmployee_id(), customerOrder.getPhone_number(), customerOrder.getDate(), customerOrder.getTime(), customerOrder.getStatus());
        double sum = 0;
        for (OrderItems q : customerOrder.getOrderItems()) {
            customerOrderRepo.addOrderItems(order_id, q.getProduct().getProduct_id(), q.getQuantity());//change so that quantity is changed
            sum += (customerOrderRepo.getPrice(q.getProduct().getId()) * q.getQuantity());
        }
        customerOrderRepo.addOrderDetails(sum, order_id);
    }

    @Transactional
    @PutMapping("/orders/{id}")
    public void updateOrder(@PathVariable Long id, @Valid @RequestBody CustomerOrder customerOrder) {
        CustomerOrder c = customerOrderRepo.findCustomerOrderById(id);
        if (Objects.nonNull(customerOrder.getPhone_number()) && customerOrder.getPhone_number() != 0) {
            c.setPhone_number(customerOrder.getPhone_number());
        }
        if (customerOrder.getEmployee_id() != 0) {
            c.setEmployee_id(customerOrder.getEmployee_id());
        }
        if (!(customerOrder.getStatus() < 0)) {
            c.setStatus(customerOrder.getStatus());
        }
        if (Objects.nonNull(customerOrder.getDate())) {
            c.setDate(customerOrder.getDate());
        }
        if (Objects.nonNull(customerOrder.getTime())) {
            c.setTime(customerOrder.getTime());
        }
        customerOrderRepo.save(c);
    }

}
