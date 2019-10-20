package com.thoughtworks.parking_lot.service;

import com.thoughtworks.parking_lot.core.ParkingLot;
import com.thoughtworks.parking_lot.repository.ParkingLotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ParkingLotService {

    @Autowired
    ParkingLotRepository parkingLotRepository;

    public ParkingLot addParkingLot(ParkingLot parkingLot)
    {
        parkingLotRepository.save(parkingLot);
        return parkingLot;
    }

    public String deleteParkingLotByName(String name) {
        parkingLotRepository.deleteByName(name);
        return "Parking Lot Was Deleted!";
    }

    public Iterable<ParkingLot> displayParkingLots(Integer page, Integer pageSize) {

        return parkingLotRepository.findAll(PageRequest.of(page, pageSize));
    }

    public ParkingLot displaySpecificParkingLot(String name) {

        return parkingLotRepository.findByName(name);
    }

    public ParkingLot modifySpecificParkingLot(String name, ParkingLot parkingLot) {
        if(parkingLotRepository.findByName(name).getName() != null)
        {
            ParkingLot parkingLot1 = parkingLotRepository.findByName(name);
            parkingLot1.setCapacity(parkingLot.getCapacity());
            parkingLotRepository.save(parkingLot1);
            return parkingLot1;
        }
        return null;
    }
}
