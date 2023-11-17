package com.example.PizzaShop.controllers;

import com.example.PizzaShop.models.BreadStick;
import com.example.PizzaShop.models.Customer;
import com.example.PizzaShop.models.CustomerOrder;
import com.example.PizzaShop.repository.CustomerRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api/v1")
public class CustomerController {

    @Autowired
    private CustomerRepo customerRepo;

    @GetMapping("/customers")
    public List<Customer> findAll(){
        return customerRepo.findAll();
    }

    @GetMapping("/customers/{phone_number}")
    public Customer findCustomerById(@PathVariable Long phone_number){
        return customerRepo.findCustomerByNumber(phone_number);
    }

    @Transactional
    @PostMapping("/customers")
    public void addCustomer(@Valid @RequestBody Customer customer){
        customerRepo.saveCustomer(customer.getPhone_number(), customer.getStreet_address(),customer.getZip_code(),customer.getState(),customer.getCity());
    }
    @Transactional
    @DeleteMapping("/customers/{phone_number}")
    public void deleteCustomer(@PathVariable Long phone_number){
        customerRepo.deleteCustomerByNumber(phone_number);
    }

    @Transactional
    @PutMapping("/customers/{phone_number}")
    public void updateCustomer(@PathVariable Long phone_number, @Valid @RequestBody Customer customer){
        Customer c = customerRepo.findCustomerByNumber(phone_number);
        if(Objects.nonNull(customer.getStreet_address()) && !customer.getStreet_address().isEmpty()){
            c.setStreet_address(customer.getStreet_address());
        }
        if(customer.getZip_code()!=0){
            c.setZip_code(customer.getZip_code());
        }
        if(Objects.nonNull(customer.getState()) &&!customer.getState().isEmpty()){
            c.setState(customer.getState());
        }
        if(Objects.nonNull(customer.getCity()) &&!customer.getCity().isEmpty()){
            c.setCity(customer.getCity());
        }
        customerRepo.save(c);
    }
}
