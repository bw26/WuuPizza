package com.example.PizzaShop.controllers;

import com.example.PizzaShop.models.Product;
import com.example.PizzaShop.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ProductController {
    @Autowired
    private ProductRepo productRepo;

    @GetMapping("/products")
    public List<Product> findAll() {
        return productRepo.findAll();
    }
    @GetMapping("/products/{id}")
    public Product findProductById(@PathVariable Long id) {
        return productRepo.findProductByID(id);
    }
}
