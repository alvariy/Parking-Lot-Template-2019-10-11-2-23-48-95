package com.thoughtworks.parking_lot.controller;

import com.thoughtworks.parking_lot.core.Orders;
import com.thoughtworks.parking_lot.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping(produces = {"application/json"})
    public Orders addOrder(@RequestBody Orders order)
    {
        return orderService.addOrder(order);
    }

    @PutMapping(value = "/{id}" , produces = {"application/json"})
    public Orders modifyOrder(@PathVariable Long id)
    {
        return orderService.modifyOrder(id);
    }
}
