package com.model;

import javax.persistence.*;
import java.math.BigInteger;


@Entity
@Table(name = "parking_history")
public class ParkingHistory {
    @Id
    @Column(name = "id")
    private int phID;
    @Column(name = "driver_name")
    private String driverName;
    @Column(name = "driver_ph_no")
    private BigInteger driverPhNo;
    @Column(name = "vehicle_type")
    private int vehicleType;
    @Column(name = "license_plate_no", unique = true)
    private String licensePlateNo;

    @Column(name = "slot_no")
    private String slotNo;


    public int getPhID() {
        return phID;
    }

    public void setPhID(int phID) {
        this.phID = phID;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public BigInteger getDriverPhNo() {
        return driverPhNo;
    }

    public void setDriverPhNo(BigInteger driverPhNo) {
        this.driverPhNo = driverPhNo;
    }

    public int getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(int vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getLicensePlateNo() {
        return licensePlateNo;
    }

    public void setLicensePlateNo(String licensePlateNo) {
        this.licensePlateNo = licensePlateNo;
    }

    public String getSlotNo() {
        return slotNo;
    }

    public void setSlotNo(String slotNo) {
        this.slotNo = slotNo;
    }


    @Override
    public String toString() {
        return "ParkingHistory{" +
                "phID=" + phID +
                ", driverName='" + driverName + '\'' +
                ", driverPhNo=" + driverPhNo +
                ", vehicleType=" + vehicleType +
                ", licensePlateNo='" + licensePlateNo + '\'' +
                ", slotNo='" + slotNo + '\'' +
                '}';
    }
}
