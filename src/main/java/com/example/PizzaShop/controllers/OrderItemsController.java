package com.example.PizzaShop.controllers;

import com.example.PizzaShop.models.OrderItems;
import com.example.PizzaShop.repository.OrderItemsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class OrderItemsController {
    @Autowired
    private OrderItemsRepo orderItemsRepoRepo;

    @GetMapping("/orders/items")
    public List<OrderItems> findAll() {
        return (List<OrderItems>) orderItemsRepoRepo.findAll();
    }

    @GetMapping("/orders/{id}/items")
    public List<OrderItems> findOrderItemsById(@PathVariable Long id) {
        return orderItemsRepoRepo.findOrderItemsByID(id);
    }

    @PostMapping("/orders/items")
    public OrderItems addOrderItem(@Valid @RequestBody OrderItems orderItems) {
        return orderItemsRepoRepo.save(orderItems);
    }
}
