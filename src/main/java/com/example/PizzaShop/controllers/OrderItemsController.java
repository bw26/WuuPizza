package com.example.PizzaShop.controllers;

import com.example.PizzaShop.models.CustomerOrder;
import com.example.PizzaShop.models.OrderItems;
import com.example.PizzaShop.repository.CustomerOrderRepo;
import com.example.PizzaShop.repository.OrderItemsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class OrderItemsController {
    @Autowired
    private OrderItemsRepo orderItemsRepoRepo;

    @GetMapping("/orders/items")
    public List<OrderItems> findAll(){
        return orderItemsRepoRepo.findAll();
    }

    @GetMapping("/orders/{id}/items")
    public OrderItems findOrderItemsById(@PathVariable Long id){
        return orderItemsRepoRepo.findOrderItemsByID(id);
    }
}
