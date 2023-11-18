package com.example.PizzaShop.repository;

import com.example.PizzaShop.models.Pizza;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PizzaRepo extends CrudRepository<Pizza, Long> {
    @Query(value = "SELECT * FROM PIZZA WHERE PRODUCT_ID = ?", nativeQuery = true)
    Pizza findPizzaByID(Long id);

    @Query(value = "SELECT * FROM PIZZA", nativeQuery = true)
    List<Pizza> findAll();

    @Query(value = "select ZEROIFNULL(MAX(PRODUCT_ID)) FROM PRODUCT", nativeQuery = true)
    int getLargestID();

    @Modifying
    @Query(value = "INSERT INTO PIZZA (PRODUCT_ID, TYPE, SIZE, PRICE) VALUES (:PRODUCT_ID, :TYPE, :SIZE, :PRICE)", nativeQuery = true)
    void savePizza(@Param("PRODUCT_ID") int product_id, @Param("TYPE") String type, @Param("SIZE") int amount, @Param("PRICE") double price);

    @Modifying
    @Query(value = "INSERT INTO PRODUCT (PRODUCT_ID, NAME) VALUES(:PRODUCT_ID, :NAME)", nativeQuery = true)
    void addToProduct(@Param("PRODUCT_ID") int product_id, @Param("NAME") String name);

    @Modifying
    @Query(value = "DELETE FROM PIZZA WHERE PRODUCT_ID = ?", nativeQuery = true)
    void deletePizzaById(Long id);

    @Modifying
    @Query(value = "DELETE FROM PRODUCT WHERE PRODUCT_ID = ?", nativeQuery = true)
    void deleteFromProduct(Long id);
}
