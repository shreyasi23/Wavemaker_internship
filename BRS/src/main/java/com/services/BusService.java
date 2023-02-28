package com.services;

import com.model.Bus;
import com.model.Passenger;

import java.util.List;

public interface BusService {
    List<Bus> getBuses();
    Bus createBus(Bus bus);
    Bus getBusById(String id);
    Bus updateBus(Bus bus);
    Bus deleteBus(String id);
}
