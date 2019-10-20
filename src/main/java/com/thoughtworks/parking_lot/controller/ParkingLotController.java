package com.thoughtworks.parking_lot.controller;

import com.thoughtworks.parking_lot.core.ParkingLot;
import com.thoughtworks.parking_lot.service.ParkingLotService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.List;

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
    public String deleteParkingLot(@PathVariable String name) throws NotFoundException {
        return parkingLotService.deleteParkingLotByName(name);
    }

    @GetMapping(produces = {"application/json"})
    public Iterable<ParkingLot> displayParkingLots(@RequestParam(defaultValue = "0") Integer page,
                                               @RequestParam(defaultValue = "15") Integer pageSize) throws NotFoundException {
        return parkingLotService.displayParkingLots(page, pageSize);
    }

    @GetMapping(value = "/{name}", produces = {"application/json"})
    public ParkingLot displaySpecificParkingLot(@PathVariable String name) throws NotFoundException {
        return  parkingLotService.displaySpecificParkingLot(name);
    }

    @PutMapping(value = "/{name}", produces = {"application/json"})
    public ParkingLot modifySpecificParkingLot(@PathVariable String name, @RequestBody ParkingLot parkingLot) throws NotFoundException {
        return parkingLotService.modifySpecificParkingLot(name, parkingLot);
    }

}
