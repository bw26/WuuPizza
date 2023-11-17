package com.example.PizzaShop.controllers;

import com.example.PizzaShop.models.BreadStick;
import com.example.PizzaShop.models.Product;
import com.example.PizzaShop.models.Soda;
import com.example.PizzaShop.repository.BreadStickRepo;
import com.example.PizzaShop.repository.SodaRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class SodaController {
    @Autowired
    private SodaRepo sodaRepo;

    @GetMapping("/products/soda")
    public List<Soda> findAll() {
        return sodaRepo.findAll();
    }
    @GetMapping("/products/soda/{id}")
    public Soda findBreadById(@PathVariable Long id) {
        return sodaRepo.findSodaByID(id);
    }
    @Transactional
    @PostMapping("/products/soda")
    public void addSoda(@Valid @RequestBody Soda soda){
        sodaRepo.saveSoda(sodaRepo.getLargestID()+1, soda.getSize(),soda.getPrice());
        sodaRepo.addToProduct(sodaRepo.getLargestID()+1, soda.getProduct().getName());
    }
    @Transactional
    @DeleteMapping("/products/soda/{id}")
    public void deleteSoda(@PathVariable Long id){
        sodaRepo.deleteSodaById(id);
        sodaRepo.deleteFromProduct(id);
    }
    @Transactional
    @PutMapping("/products/soda/{id}")
    public void updateBreadStick(@PathVariable Long id, @Valid @RequestBody Soda soda){
        Soda s = sodaRepo.findSodaByID(id);
        if(soda.getSize()!=0){
            s.setSize(soda.getSize());
        }
        if(soda.getPrice()!=0){
            s.setPrice(soda.getPrice());
        }
        sodaRepo.save(s);
    }

}
