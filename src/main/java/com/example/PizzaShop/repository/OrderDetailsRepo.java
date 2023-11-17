package com.example.PizzaShop.repository;

import com.example.PizzaShop.models.OrderDetails;
import com.example.PizzaShop.models.OrderItems;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDetailsRepo extends CrudRepository<OrderDetails,Long> {
    @Query(value = "SELECT * FROM ORDER_DETAILS WHERE ORDER_ID = ?", nativeQuery = true)
    OrderDetails findOrderDetailsByID(Long id);

    @Query(value = "SELECT * FROM ORDER_DETAILS",nativeQuery = true)
    List<OrderDetails> findAll();
}
