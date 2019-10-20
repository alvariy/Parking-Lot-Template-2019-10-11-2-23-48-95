package com.thoughtworks.parking_lot.service;

import com.thoughtworks.parking_lot.core.Orders;
import com.thoughtworks.parking_lot.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    public Orders addOrder(Orders order)
    {
        order.setCloseDate(null);
        order.setCreationDate("2019-10-21");
        order.setNameOfParkingLot(order.getNameOfParkingLot());
        order.setOrderStatus("Open");
        order.setPlateNumber(order.getPlateNumber());

        orderRepository.save(order);
        return order;
    }

}
