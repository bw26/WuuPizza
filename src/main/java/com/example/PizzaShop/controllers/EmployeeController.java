package com.example.PizzaShop.controllers;

import com.example.PizzaShop.models.CustomerOrder;
import com.example.PizzaShop.models.Employee;
import com.example.PizzaShop.repository.EmployeeRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api/v1")
public class EmployeeController {
    @Autowired
    private EmployeeRepo employeeRepo;

    @GetMapping("/employee")
    public List<Employee> findAll() {
        return employeeRepo.findAll();
    }

    @GetMapping("/employee/{id}")
    public Employee findEmployeeById(@PathVariable Long id) {
        return employeeRepo.findEmployeeByID(id);
    }

    @GetMapping("/employee/{id}/orders")
    public List<CustomerOrder> findEmployeeOrder(@PathVariable Long id, @RequestParam(required = false) boolean byWeek) {
        if(byWeek){
            return employeeRepo.getEmployeeOrderByWeek(id);
        }
        return employeeRepo.findEmployeeByID(id).getCustomerOrders();
    }

    @Transactional
    @PostMapping("/employee")
    public void addEmployee(@Valid @RequestBody Employee employee) {
        employeeRepo.saveEmployee(employeeRepo.getLargestID() + 1, employee.getEmployee_name(), employee.getEmployment_status(), employee.getPassword());
    }

    @Transactional
    @DeleteMapping("/employee/{id}")
    public void deleteEmployee(@PathVariable Long id) {
        employeeRepo.deleteEmployeeById(id);
    }

    @Transactional
    @PutMapping("/employee/{id}")
    public void updateEmployee(@PathVariable Long id, @Valid @RequestBody Employee employee) {
        Employee e = employeeRepo.findEmployeeByID(id);

        if (employee.getEmployment_status() != 0) {
            e.setEmployment_status(employee.getEmployment_status());
        }
        if (Objects.nonNull(employee.getEmployee_name()) && !(employee.getEmployee_name().isEmpty())) {
            e.setEmployee_name(employee.getEmployee_name());
        }
        if (Objects.nonNull(employee.getPassword()) && !(employee.getPassword().isEmpty())) {
            e.setPassword(employee.getPassword());
        }
        employeeRepo.save(e);
    }
}

