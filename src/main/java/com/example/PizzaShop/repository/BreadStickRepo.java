package com.example.PizzaShop.repository;

import com.example.PizzaShop.models.BreadStick;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BreadStickRepo extends CrudRepository<BreadStick, Long> {
    @Query(value = "SELECT * FROM BREADSTICK WHERE PRODUCT_ID = ?", nativeQuery = true)
    BreadStick findBreadByID(Long id);

    @Query(value = "SELECT * FROM BREADSTICK",nativeQuery = true)
    List<BreadStick> findAll();

    @Query(value = "select ZEROIFNULL(MAX(PRODUCT_ID)) FROM PRODUCT", nativeQuery = true)
    int getLargestID();

    @Modifying
    @Query(value = "INSERT INTO BREADSTICK (PRODUCT_ID, AMOUNT, PRICE) VALUES (:PRODUCT_ID, :AMOUNT, :PRICE)", nativeQuery = true)
    void saveBread(@Param("PRODUCT_ID") int product_id, @Param("AMOUNT") int amount, @Param("PRICE") double price);

    @Modifying
    @Query(value = "INSERT INTO PRODUCT (PRODUCT_ID, NAME) VALUES(:PRODUCT_ID, :NAME)", nativeQuery = true)
    void addToProduct(@Param("PRODUCT_ID") int product_id, @Param("NAME") String name);

    @Modifying
    @Query(value = "DELETE FROM BREADSTICK WHERE PRODUCT_ID = ?", nativeQuery = true)
    void deleteBreadStickById(Long id);
    @Modifying
    @Query(value = "DELETE FROM PRODUCT WHERE PRODUCT_ID = ?", nativeQuery = true)
    void deleteFromProduct(Long id);
}
