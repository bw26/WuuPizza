package com.example.PizzaShop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication(scanBasePackages = {"com.example.PizzaShop.controllers", "com.example.PizzaShop.models", "com.example.PizzaShop.repository"})
public class PizzaShopApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(PizzaShopApplication.class, args);
    }
}
