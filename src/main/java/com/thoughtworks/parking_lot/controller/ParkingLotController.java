package com.thoughtworks.parking_lot.controller;

import com.thoughtworks.parking_lot.core.ParkingLot;
import com.thoughtworks.parking_lot.service.ParkingLotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.awt.*;

@RestController
@RequestMapping("/parking-lots")
public class ParkingLotController {

    @Autowired
    ParkingLotService parkingLotService;

    @PostMapping(produces = {"application/json"})
    public ParkingLot addParkingLot(@RequestBody ParkingLot parkingLot)
    {
        return parkingLotService.addParkingLot(parkingLot);
    }

    @DeleteMapping(value = "/{name}", produces = {"application/json"})
    public String deleteParkingLot(@PathVariable String name)
    {
        return parkingLotService.deleteParkingLotByName(name);
    }

}
