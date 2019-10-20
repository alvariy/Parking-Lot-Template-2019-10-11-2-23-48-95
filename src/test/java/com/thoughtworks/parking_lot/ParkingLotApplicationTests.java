package com.thoughtworks.parking_lot;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.thoughtworks.parking_lot.controller.ParkingLotController;
import com.thoughtworks.parking_lot.core.ParkingLot;
import com.thoughtworks.parking_lot.service.ParkingLotService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.hasSize;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(ParkingLotController.class)
@ActiveProfiles(profiles = "test")

public class ParkingLotApplicationTests {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mvc;

    @MockBean
    private ParkingLotService parkingLotService;

    @Test
    public void should_return_parking_lot_info_if_successfully_added() throws Exception {

        ParkingLot parkingLot = new ParkingLot("Maax GF", 15, "Pasay City");

        //given
        when(parkingLotService.addParkingLot(any())).thenReturn(parkingLot);
        //when
        ResultActions result = mvc.perform(post("/parking-lots")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(parkingLot)));

        result.andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$.name", is("Maax GF")));

    }

    @Test
    public void should_delete_parking_lot_and_return_is_okay() throws Exception {

        when(parkingLotService.deleteParkingLotByName(anyString())).thenReturn("Parking Lot Was Deleted!");
        //when
        ResultActions result = mvc.perform(delete("/parking-lots/Maax"));
        //then
        result.andExpect(status().isOk());
    }

    @Test
    public void should_get_all_list_with_15_page_size() throws Exception {

        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(new ParkingLot());
        parkingLots.add(new ParkingLot());

        //given
        when(parkingLotService.displayParkingLots(0,15)).thenReturn(parkingLots);
        //when
        ResultActions result = mvc.perform(get("/parking-lots"));
        //then
        result.andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$", hasSize(2)));
    }
    @Test
    public void should_get_specific_parking_lot() throws Exception {

        ParkingLot parkingLot = new ParkingLot("MAAX", 15, "Pasay City");

        //given
        when(parkingLotService.displaySpecificParkingLot(anyString())).thenReturn(parkingLot);
        //when
        ResultActions result = mvc.perform(get("/parking-lots/MAAX"));
        //then
        result.andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$.name", is("MAAX")));
    }

    @Test
    void should_modify_specific_parking_lot_capacity() throws Exception {

        ParkingLot parkingLot = new ParkingLot("MAAX", 15, "Pasay City");
        ParkingLot parkingLot2 = new ParkingLot("MAAX", 10, "Pasay City");

        //given
        when(parkingLotService.modifySpecificParkingLot(anyString(), any())).thenReturn(parkingLot2);

        ResultActions result = mvc.perform(put("/parking-lots/MAAX")
        .content(objectMapper.writeValueAsString(parkingLot2))
        .contentType(MediaType.APPLICATION_JSON));

        result.andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$.capacity", is(10)));
    }
}
