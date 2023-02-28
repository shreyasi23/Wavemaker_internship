package com.controller;

import com.model.Bus;
import com.model.Driver;
import com.services.DriverService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping(value = "/driver")
public class DriverController {
    @Autowired
    DriverService driverService;
    private static final Logger logger = LoggerFactory.getLogger(DriverController.class);

    @GetMapping
    public List<Driver> getDrivers(){
        logger.info("Driver list");
        return driverService.getDrivers();
    }

    @PostMapping("/create-driver")
    public Driver createDriver(@RequestBody Driver driver){
        logger.info("create Driver is invoked {}",driver);
        return driverService.createDriver(driver);
    }

    @GetMapping("/{id}")
    public Driver getDriverById(@PathVariable("id") String id){
        logger.info("getDriverById is invoked with Passenger ID: {}",id);
        return driverService.getDriverById(id);
    }

    @PutMapping("/update-driver")
    public Driver updateDriver(@RequestBody Driver driver){
        return driverService.updateDriver(driver);
    }

    @DeleteMapping("{/id}")
    public Driver deleteDriver(@PathVariable("id") String id){
        return driverService.deleteDriver(id);
    }
}
