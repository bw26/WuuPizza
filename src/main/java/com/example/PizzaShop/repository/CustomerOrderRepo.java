package com.example.PizzaShop.repository;

import com.example.PizzaShop.models.CustomerOrder;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

@Repository
public interface CustomerOrderRepo extends CrudRepository<CustomerOrder, Long> {

    @Query(value = "SELECT * FROM CUSTOMERORDER WHERE ORDER_ID = ?", nativeQuery = true)
    CustomerOrder findCustomerOrderById(Long id);

    @Query(value = "SELECT * FROM CUSTOMERORDER", nativeQuery = true)
    List<CustomerOrder> findAll();

    @Query(value = "SELECT ZEROIFNULL(MAX(ORDER_ID)) FROM CUSTOMERORDER", nativeQuery = true)
    int getLargestID();

    @Modifying
    @Query(value = "INSERT INTO ORDER_ITEMS(ORDER_ID, PRODUCT_ID, QUANTITY) VALUES(:ORDER_ID, :PRODUCT_ID, :QUANTITY)", nativeQuery = true)
    void addOrderItems(@Param("ORDER_ID") int order_id, @Param("PRODUCT_ID") int product_id, @Param("QUANTITY") int quantity);

    @Modifying
    @Query(value = "INSERT INTO CUSTOMERORDER (ORDER_ID, EMPLOYEE_ID, PHONE_NUMBER, DATE, TIME, STATUS) VALUES (:ORDER_ID, :EMPLOYEE_ID, :PHONE_NUMBER, :DATE, :TIME, :STATUS)", nativeQuery = true)
    void saveOrder(@Param("ORDER_ID") int order_id, @Param("EMPLOYEE_ID") int employee_id, @Param("PHONE_NUMBER") Long phone_number, @Param("DATE") Date date, @Param("TIME") Time time, @Param("STATUS") int status);

    @Query(value = "SELECT PRICE FROM (SELECT p.PRODUCT_ID, PRICE from PRODUCT p INNER JOIN SODA s ON s.product_id = p.product_id UNION ALL SELECT p.PRODUCT_ID, PRICE from PRODUCT p INNER JOIN PIZZA piz ON piz.product_id = p.product_id UNION ALL SELECT p.PRODUCT_ID, PRICE from PRODUCT p INNER JOIN BREADSTICK b ON b.product_id = p.product_id) WHERE PRODUCT_ID = ?", nativeQuery = true)
    double getPrice(int id);

    @Modifying
    @Query(value = "INSERT INTO ORDERDETAILS (PRICE_CHARGED, ORDER_ID) VALUES (:PRICE_CHARGED, :ORDER_ID)", nativeQuery = true)
    void addOrderDetails(@Param("PRICE_CHARGED") double price_charged, @Param("ORDER_ID") int order_id);

}
