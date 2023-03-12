package com.service;

import com.model.ParkingHistory;

import java.util.List;

public interface ParkingHistoryService {
    List<ParkingHistory> getParkingHistory();

    ParkingHistory recordParkingInfo(ParkingHistory parkingHistory);

    List<ParkingHistory> getHistory(String license_plate_no);

    List<ParkingHistory> getPRWheelerWise(int vehicle_type);
}
