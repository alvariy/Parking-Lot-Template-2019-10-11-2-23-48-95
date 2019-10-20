package com.thoughtworks.parking_lot.service;

import com.thoughtworks.parking_lot.core.ParkingLot;
import com.thoughtworks.parking_lot.repository.ParkingLotRepository;
import javassist.NotFoundException;
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

    public String deleteParkingLotByName(String name) throws NotFoundException {
        if(parkingLotRepository.findByName(name).getName() != null) {
            parkingLotRepository.deleteByName(name);
            return "Parking Lot Was Deleted!";
        }
        throw new NotFoundException("No parking lot was deleted!");

    }

    public Iterable<ParkingLot> displayParkingLots(Integer page, Integer pageSize) throws NotFoundException {
        if(parkingLotRepository.findAll(PageRequest.of(page, pageSize)).getTotalElements() > 0) {
            return parkingLotRepository.findAll(PageRequest.of(page, pageSize));
        }
        throw new NotFoundException("No parking lot was found!");
    }

    public ParkingLot displaySpecificParkingLot(String name) throws NotFoundException {
        if(parkingLotRepository.findByName(name).getName() != null) {
            return parkingLotRepository.findByName(name);
        }
        throw new NotFoundException("No parking lot was found!");
    }

    public ParkingLot modifySpecificParkingLot(String name, ParkingLot parkingLot) throws NotFoundException {
        if(parkingLotRepository.findByName(name).getName() != null)
        {
            ParkingLot parkingLot1 = parkingLotRepository.findByName(name);
            parkingLot1.setCapacity(parkingLot.getCapacity());
            parkingLotRepository.save(parkingLot1);
            return parkingLot1;
        }
        throw new NotFoundException("No parking lot was modified!");
    }
}
