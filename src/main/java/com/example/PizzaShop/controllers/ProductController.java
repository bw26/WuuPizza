package com.example.PizzaShop.controllers;

import com.example.PizzaShop.models.Product;
import com.example.PizzaShop.repository.ProductRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Objects;

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

    @Transactional
    @PutMapping("/products/{id}")
    public void updateProduct(@PathVariable Long id, @Valid @RequestBody Product product) {
        Product p = productRepo.findProductByID(id);
        if (Objects.nonNull(product.getName()) && !(product.getName().isEmpty())) {
            p.setName(product.getName());
        }
        productRepo.save(p);
    }

}
