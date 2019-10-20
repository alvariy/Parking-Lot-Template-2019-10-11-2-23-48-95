package com.thoughtworks.parking_lot.service;

import com.thoughtworks.parking_lot.core.Orders;
import com.thoughtworks.parking_lot.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    public Orders addOrder(Orders order)
    {
        order.setCloseDate(null);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        order.setCreationDate(dtf.format(now));
        order.setNameOfParkingLot(order.getNameOfParkingLot());
        order.setOrderStatus("Open");
        order.setPlateNumber(order.getPlateNumber());

        orderRepository.save(order);
        return order;
    }

    public Orders modifyOrder(Long orderNumber) {

        Orders order1 = orderRepository.findByOrderId(orderNumber);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        order1.setCloseDate(dtf.format(now));
        order1.setOrderStatus("Close");

        return order1;

    }
}
