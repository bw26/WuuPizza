package com.example.PizzaShop.repository;

import com.example.PizzaShop.models.CustomerOrder;
import com.example.PizzaShop.models.Employee;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepo extends CrudRepository<Employee, Long> {
    @Query(value = "SELECT * FROM EMPLOYEE WHERE EMPLOYEE_ID = ?", nativeQuery = true)
    Employee findEmployeeByID(Long id);

    @Query(value = "SELECT * FROM EMPLOYEE", nativeQuery = true)
    List<Employee> findAll();

    @Query(value = "select ZEROIFNULL(MAX(EMPLOYEE_ID)) FROM EMPLOYEE", nativeQuery = true)
    int getLargestID();

    @Query(value = "SELECT o.ORDER_ID, o.EMPLOYEE_ID, o.PHONE_NUMBER, o.DATE, o.TIME, o.STATUS FROM CUSTOMERORDER o INNER JOIN EMPLOYEE e ON o.EMPLOYEE_ID = e.EMPLOYEE_ID WHERE CURRENT_DATE() - o.DATE <= 7 AND WEEK(o.DATE)= WEEK(CURRENT_DATE())", nativeQuery = true)
    List<CustomerOrder> getEmployeeOrderByWeek(@Param("EMPLOYEE_ID") Long employee_id);

    @Modifying
    @Query(value = "INSERT INTO EMPLOYEE (EMPLOYEE_ID, EMPLOYEE_NAME, EMPLOYMENT_STATUS, PASSWORD) VALUES (:EMPLOYEE_ID, :EMPLOYEE_NAME, :EMPLOYMENT_STATUS, :PASSWORD)", nativeQuery = true)
    void saveEmployee(@Param("EMPLOYEE_ID") int employee_id, @Param("EMPLOYEE_NAME") String employee_name, @Param("EMPLOYMENT_STATUS") int employee_status, @Param("PASSWORD") String password);

    @Modifying
    @Query(value = "DELETE FROM EMPLOYEE WHERE EMPLOYEE_ID = ?", nativeQuery = true)
    void deleteEmployeeById(Long id);
}
