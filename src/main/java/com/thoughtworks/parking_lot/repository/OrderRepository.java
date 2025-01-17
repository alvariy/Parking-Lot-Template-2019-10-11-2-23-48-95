package com.thoughtworks.parking_lot.repository;

import com.thoughtworks.parking_lot.core.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Orders, Long> {


    @Query("Select o from Orders o where o.orderNumber = :orderNumber")
    Orders findByOrderId(@Param("orderNumber") Long orderNumber);
}
