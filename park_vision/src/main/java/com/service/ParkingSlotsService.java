package com.service;

import com.model.ParkingHistory;
import com.model.ParkingSlots;

import java.util.List;

public interface ParkingSlotsService {
    List<ParkingSlots> getParkingSlots();

    ParkingSlots getSlot(String slot_no);

    ParkingSlots updateSlotStatus(ParkingSlots parkingSlots);
}
