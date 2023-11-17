package com.example.PizzaShop.controllers;

import com.example.PizzaShop.models.Customer;
import com.example.PizzaShop.models.CustomerOrder;
import com.example.PizzaShop.models.OrderItems;
import com.example.PizzaShop.models.Product;
import com.example.PizzaShop.repository.CustomerOrderRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api/v1")
public class CustomerOrderController {

    @Autowired
    private CustomerOrderRepo customerOrderRepo;

    @GetMapping("/orders")
    public List<CustomerOrder> findAll(){
        return customerOrderRepo.findAll();
    }

    @GetMapping("/orders/{id}")
    public CustomerOrder findCustomerOrderById(@PathVariable Long id){
        return customerOrderRepo.findCustomerOrderById(id);
    }

    @Transactional
    @PostMapping("/orders")
    public void addOrder(@Valid @RequestBody CustomerOrder customerOrder) {
        int id = customerOrderRepo.getLargestID() + 1;
        customerOrderRepo.saveOrder(id, customerOrder.getEmployee_id(), customerOrder.getPhone_number(), customerOrder.getDate(), customerOrder.getTime(), customerOrder.getStatus());
        List<Product> prods = customerOrder.getProducts();
        for (Product p : prods) {
            customerOrderRepo.addOrderItems(id, p.getId(), 1);
        }
        customerOrderRepo.addOrderDetails(customerOrderRepo.getPrice(id), id);
    }
    @Transactional
    @PutMapping("/orders/{id}")
    public void updateOrder(@PathVariable Long id, @Valid @RequestBody CustomerOrder customerOrder){
        CustomerOrder c = customerOrderRepo.findCustomerOrderById(id);
        if(Objects.nonNull(customerOrder.getPhone_number())&&customerOrder.getPhone_number()!=0){
            c.setPhone_number(customerOrder.getPhone_number());
        }
        if(customerOrder.getEmployee_id()!=0){
            c.setEmployee_id(customerOrder.getEmployee_id());
        }
        if(!(customerOrder.getStatus()<0)){
            c.setStatus(customerOrder.getStatus());
        }
        if(Objects.nonNull(customerOrder.getDate())){
            c.setDate(customerOrder.getDate());
        }
        if(Objects.nonNull(customerOrder.getTime())){
            c.setTime(customerOrder.getTime());
        }
        customerOrderRepo.save(c);
    }

}
