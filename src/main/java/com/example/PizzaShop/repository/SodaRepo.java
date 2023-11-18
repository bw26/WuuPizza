package com.example.PizzaShop.repository;

import com.example.PizzaShop.models.Soda;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SodaRepo extends CrudRepository<Soda, Long> {
    @Query(value = "SELECT * FROM SODA WHERE PRODUCT_ID = ?", nativeQuery = true)
    Soda findSodaByID(Long id);

    @Query(value = "SELECT * FROM SODA", nativeQuery = true)
    List<Soda> findAll();

    @Query(value = "select ZEROIFNULL(MAX(PRODUCT_ID)) FROM PRODUCT", nativeQuery = true)
    int getLargestID();

    @Modifying
    @Query(value = "INSERT INTO SODA (PRODUCT_ID, SIZE, PRICE) VALUES (:PRODUCT_ID, :SIZE, :PRICE)", nativeQuery = true)
    void saveSoda(@Param("PRODUCT_ID") int product_id, @Param("SIZE") int size, @Param("PRICE") double price);

    @Modifying
    @Query(value = "INSERT INTO PRODUCT (PRODUCT_ID, NAME) VALUES(:PRODUCT_ID, :NAME)", nativeQuery = true)
    void addToProduct(@Param("PRODUCT_ID") int product_id, @Param("NAME") String name);

    @Modifying
    @Query(value = "DELETE FROM SODA WHERE PRODUCT_ID = ?", nativeQuery = true)
    void deleteSodaById(Long id);

    @Modifying
    @Query(value = "DELETE FROM PRODUCT WHERE PRODUCT_ID = ?", nativeQuery = true)
    void deleteFromProduct(Long id);
}
