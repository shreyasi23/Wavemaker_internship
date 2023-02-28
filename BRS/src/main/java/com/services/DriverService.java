package com.services;

import com.model.Driver;

import java.util.List;

public interface DriverService {
    List<Driver> getDrivers();
    Driver createDriver(Driver driver);
    Driver getDriverById(String id);
    Driver updateDriver(Driver driver);
    Driver deleteDriver(String id);
}
