package com.controller;

import com.model.Bus;
import com.services.BusService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(value = "/bus")
public class BusController {

    @Autowired
    BusService busService;
    private static final Logger logger = LoggerFactory.getLogger(BusController.class);

    @GetMapping
    public List<Bus> getBuses(){
        logger.info("Bus list");
        return busService.getBuses();
    }

    @PostMapping("/create-bus")
    public Bus createBus(@RequestBody Bus bus){
        logger.info("create Bus is invoked {}",bus);
        return busService.createBus(bus);
    }

    @GetMapping("/{id}")
    public Bus getBusById(@PathVariable("id") String id){
        logger.info("getBusById is invoked with Bus ID: {}",id);
        return busService.getBusById(id);
    }

    @PutMapping("/update-bus")
    public Bus updateBus(@RequestBody Bus passenger){
        return busService.updateBus(passenger);
    }

    @DeleteMapping("{/id}")
    public Bus deleteBus(@PathVariable("id") String id){
        return busService.deleteBus(id);
    }
}
