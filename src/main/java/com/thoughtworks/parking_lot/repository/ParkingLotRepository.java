package com.thoughtworks.parking_lot.repository;

import com.thoughtworks.parking_lot.core.ParkingLot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface ParkingLotRepository extends JpaRepository<ParkingLot, Long> {

    @Transactional
    @Modifying
    @Query("DELETE FROM ParkingLot p where p.name = :name")
    void deleteByName(@Param("name") String name);
}
