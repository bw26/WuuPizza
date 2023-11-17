package com.example.PizzaShop.controllers;

import com.example.PizzaShop.models.OrderDetails;
import com.example.PizzaShop.models.OrderItems;
import com.example.PizzaShop.repository.OrderDetailsRepo;
import com.example.PizzaShop.repository.OrderItemsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class OrderDetailsController {

    @Autowired
    private OrderDetailsRepo orderDetailsRepo;

    @GetMapping("/orders/details")
    public List<OrderDetails> findAll(){
        return orderDetailsRepo.findAll();
    }

    @GetMapping("/orders/details/{id}")
    public OrderDetails findOrderDetailsById(@PathVariable Long id){
        return orderDetailsRepo.findOrderDetailsByID(id);
    }
}
