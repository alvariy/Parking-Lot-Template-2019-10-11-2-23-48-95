package com.thoughtworks.parking_lot.core;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ParkingLot {


    @Id
    private String name;

    private int capacity;

    private String location;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public ParkingLot(String name, int capacity, String location) {
        this.name = name;
        this.capacity = capacity;
        this.location = location;
    }

    public ParkingLot() {
    }

    public ParkingLot(int capacity) {
        this.capacity = capacity;
    }

}
