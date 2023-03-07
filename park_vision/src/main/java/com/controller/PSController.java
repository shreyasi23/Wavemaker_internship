package com.controller;

import com.model.Invoice;
import com.model.ParkingSlots;
import com.service.ParkingSlotsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/parking-slots")
public class PSController {
    @Autowired
    ParkingSlotsService parkingSlotsService;
    private static final Logger logger = LoggerFactory.getLogger(InvoiceController.class);

    @GetMapping
    public List<ParkingSlots> getParkingSlots(){
        logger.info("parking slots record");
        return parkingSlotsService.getParkingSlots();
    }

    @GetMapping("/{id}")
    public ParkingSlots getSlot(@PathVariable("id") String id){
        logger.info("getSlot is invoked with slot ID: {}",id);
        return parkingSlotsService.getSlot(id);
    }

    @PutMapping("/update-status")
    public ParkingSlots updateSlotStatus(@RequestBody ParkingSlots parkingSlots){
        return parkingSlotsService.updateSlotStatus(parkingSlots);
    }
}
