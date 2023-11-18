package com.example.PizzaShop.repository;

import com.example.PizzaShop.models.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo extends CrudRepository<Product, Long> {
    @Query(value = "SELECT * FROM PRODUCT WHERE PRODUCT_ID = ?", nativeQuery = true)
    Product findProductByID(Long id);

    @Query(value = "SELECT * FROM PRODUCT", nativeQuery = true)
    List<Product> findAll();
}
