package com.example.PizzaShop.controllers;

import com.example.PizzaShop.models.BreadStick;
import com.example.PizzaShop.models.Pizza;
import com.example.PizzaShop.models.Soda;
import com.example.PizzaShop.repository.PizzaRepo;
import com.example.PizzaShop.repository.SodaRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class PizzaController {

    @Autowired
    private PizzaRepo pizzaRepo;

    @GetMapping("/products/pizza")
    public List<Pizza> findAll() {
        return pizzaRepo.findAll();
    }
    @GetMapping("/products/pizza/{id}")
    public Pizza findBreadById(@PathVariable Long id) {
        return pizzaRepo.findPizzaByID(id);
    }

    @Transactional
    @PostMapping("/products/pizza")
    public void addPizza(@Valid @RequestBody Pizza pizza){
        pizzaRepo.savePizza(pizzaRepo.getLargestID()+1, pizza.getType(), pizza.getSize(),pizza.getPrice());
        pizzaRepo.addToProduct(pizzaRepo.getLargestID()+1, pizza.getProduct().getName());
    }
    @Transactional
    @DeleteMapping("/products/pizza/{id}")
    public void deletePizza(@PathVariable Long id){
        pizzaRepo.deletePizzaById(id);
        pizzaRepo.deleteFromProduct(id);
    }
    @Transactional
    @PutMapping("/products/pizza/{id}")
    public void updateBreadStick(@PathVariable Long id, @Valid @RequestBody Pizza pizza){
        Pizza p = pizzaRepo.findPizzaByID(id);
        if(pizza.getSize()!=0){
            p.setSize(pizza.getSize());
        }
        if(pizza.getPrice()!=0){
            p.setPrice(pizza.getPrice());
        }
        if(!(pizza.getType().isEmpty())){
            p.setType(pizza.getType());
        }
        pizzaRepo.save(p);
    }
}
