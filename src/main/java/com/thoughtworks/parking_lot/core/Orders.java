package com.thoughtworks.parking_lot.core;


import javax.persistence.*;

@Entity
public class Orders {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long orderNumber;

    private String nameOfParkingLot;

    private String plateNumber;
    private String creationDate;
    private String closeDate;
    private String orderStatus;

    public Orders() {
    }

    public Long getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(Long orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getNameOfParkingLot() {
        return nameOfParkingLot;
    }

    public void setNameOfParkingLot(String nameOfParkingLot) {
        this.nameOfParkingLot = nameOfParkingLot;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public String getCloseDate() {
        return closeDate;
    }

    public void setCloseDate(String closeDate) {
        this.closeDate = closeDate;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }
}
