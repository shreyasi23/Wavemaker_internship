package com.controller;

import com.model.Passenger;
import com.services.PassengerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(value = "/passenger")
public class PassengerController {
    @Autowired
    PassengerService passengerService;
    private static final Logger logger = LoggerFactory.getLogger(PassengerController.class);

    @GetMapping
    public List<Passenger> getPassengers(){
        logger.info("Passenger list");
        return passengerService.getPassengers();
    }

    @PostMapping("/create-passenger")
    public Passenger createPassenger(@RequestBody Passenger passenger){
        logger.info("create Passenger is invoked {}",passenger);
        return passengerService.createPassenger(passenger);
    }

    @GetMapping("/{id}")
    public Passenger getPassengerById(@PathVariable("id") String id){
        logger.info("getPassengerById is invoked with Passenger ID: {}",id);
        return passengerService.getPassengerById(id);
    }

    @PutMapping("/update-passenger")
    public Passenger updatePassenger(@RequestBody Passenger passenger){
        return passengerService.updatePassenger(passenger);
    }

    @DeleteMapping("{/id}")
    public Passenger deletePassenger(@PathVariable("id") String id){
        return passengerService.deletePassenger(id);
    }
}
