package com.example.PizzaShop.repository;

import com.example.PizzaShop.models.Customer;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepo extends CrudRepository<Customer,Long> {

    @Query(value = "SELECT * FROM CUSTOMER WHERE PHONE_NUMBER = ?",nativeQuery = true)
    Customer findCustomerByNumber(Long id);

    @Query(value = "SELECT * FROM CUSTOMER",nativeQuery = true)
    List<Customer> findAll();


    @Modifying
    @Query(value = "INSERT INTO CUSTOMER (PHONE_NUMBER, STREET_ADDRESS, ZIP_CODE, STATE, CITY) VALUES (:PHONE_NUMBER, :STREET_ADDRESS, :ZIP_CODE, :STATE, :CITY)", nativeQuery = true)
    void saveCustomer(@Param("PHONE_NUMBER") Long phone_number, @Param("STREET_ADDRESS") String street_address, @Param("ZIP_CODE") int zip_code, @Param("STATE") String state, @Param("CITY") String city);

    @Modifying
    @Query(value = "DELETE FROM CUSTOMER WHERE PHONE_NUMBER = ?", nativeQuery = true)
    void deleteCustomerByNumber(Long phone);

    @Modifying
    @Query(value = "UPDATE CUSTOMERORDER SET PHONE_NUMBER = :PHONE_NUMBER WHERE PHONE_NUMBER = :PREV_PHONE", nativeQuery = true)
    void updateCustomerOrderByNumber(@Param("PHONE_NUMBER") Long phone_number, @Param("PREV_PHONE") Long prev_phone);
}
