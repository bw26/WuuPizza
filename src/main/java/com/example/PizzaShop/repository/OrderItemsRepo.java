package com.example.PizzaShop.repository;

import com.example.PizzaShop.models.OrderItems;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderItemsRepo extends CrudRepository<OrderItems, Long> {

    @Query(value = "SELECT * FROM ORDER_ITEMS WHERE ORDER_ID = ?", nativeQuery = true)
    List<OrderItems> findOrderItemsByID(Long id);

    @Query(value = "SELECT * FROM ORDER_ITEMS", nativeQuery = true)
    List<OrderItems> findAll();

}
