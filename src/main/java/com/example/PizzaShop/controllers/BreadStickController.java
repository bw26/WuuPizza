package com.example.PizzaShop.controllers;

import com.example.PizzaShop.models.BreadStick;
import com.example.PizzaShop.repository.BreadStickRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class BreadStickController {

    @Autowired
    private BreadStickRepo breadStickRepo;

    @GetMapping("/products/breadstick")
    public List<BreadStick> findAll() {
        return breadStickRepo.findAll();
    }

    @GetMapping("/products/breadstick/{id}")
    public BreadStick findBreadById(@PathVariable Long id) {
        return breadStickRepo.findBreadByID(id);
    }

    @Transactional
    @PostMapping("/products/breadstick")
    public void addBreadStick(@Valid @RequestBody BreadStick breadStick) {
        breadStickRepo.saveBread(breadStickRepo.getLargestID() + 1, breadStick.getAmount(), breadStick.getPrice());
        breadStickRepo.addToProduct(breadStickRepo.getLargestID() + 1, breadStick.getProduct().getName());
    }

    @Transactional
    @DeleteMapping("/products/breadstick/{id}")
    public void deleteBreadStick(@PathVariable Long id) {
        breadStickRepo.deleteBreadStickById(id);
        breadStickRepo.deleteFromProduct(id);
    }

    @Transactional
    @PutMapping("/products/breadstick/{id}")
    public void updateBreadStick(@PathVariable Long id, @Valid @RequestBody BreadStick breadStick) {
        BreadStick b = breadStickRepo.findBreadByID(id);
        if (breadStick.getAmount() != 0) {
            b.setAmount(breadStick.getAmount());
        }
        if (breadStick.getPrice() != 0) {
            b.setPrice(breadStick.getPrice());
        }
        breadStickRepo.save(b);
    }

}
