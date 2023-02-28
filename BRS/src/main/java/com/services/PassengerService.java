package com.services;

import com.model.Passenger;

import java.util.List;

public interface PassengerService {

    List<Passenger> getPassengers();
    Passenger createPassenger(Passenger passenger);
    Passenger getPassengerById(String id);
    Passenger updatePassenger(Passenger passenger);
    Passenger deletePassenger(String id);
}
