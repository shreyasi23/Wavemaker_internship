package com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigInteger;
import java.sql.Date;
import java.sql.Time;

@Entity
@Table(name = "parking_history")
public class ParkingHistory {
    @Id
    @Column(name = "id")
    private String phID;
    @Column(name = "entry_date")
    private Date entryDate;
    @Column(name = "driver_name")
    private String driverName;
    @Column(name = "driver_ph_no")
    private BigInteger driverPhNo;
    @Column(name = "vehicle_make")
    private String vehicleMake;
    @Column(name = "vehicle_type")
    private int vehicleType;
    @Column(name = "license_plate_no", unique = true)
    private String licensePlateNo;
    @Column(name = "slot_no")
    private String slotNo;
    @Column(name = "entry_time")
    private Time entryTime;
    @Column(name = "exit_time")
    private Time exitTime;

//    public ParkingHistory() {
//        this.phID = "PH0";
//        this.entryDate = new Date(2023,01,01);
//        this.driverName = "xyz";
//        this.driverPhNo = BigInteger.valueOf(1234567891);
//        this.vehicleMake = "MSD";
//        this.vehicleType = 4;
//        this.licensePlateNo = "LC00XZ0000";
//        this.slotNo = "A-00";
//        this.entryTime = new Time(00,00,00);
//        this.exitTime = new Time(00,00,00);
//    }

    public String getPhID() {
        return phID;
    }

    public void setPhID(String phID) {
        this.phID = phID;
    }

    public Date getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(Date entryDate) {
        this.entryDate = entryDate;
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

    public String getVehicleMake() {
        return vehicleMake;
    }

    public void setVehicleMake(String vehicleMake) {
        this.vehicleMake = vehicleMake;
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

    public Time getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(Time entryTime) {
        this.entryTime = entryTime;
    }

    public Time getExitTime() {
        return exitTime;
    }

    public void setExitTime(Time exitTime) {
        this.exitTime = exitTime;
    }

    @Override
    public String toString() {
        return "ParkingHistory{" +
                "phID='" + phID + '\'' +
                ", entryDate=" + entryDate +
                ", driverName='" + driverName + '\'' +
                ", driverPhNo=" + driverPhNo +
                ", vehicleMake='" + vehicleMake + '\'' +
                ", vehicleType=" + vehicleType +
                ", licensePlateNo='" + licensePlateNo + '\'' +
                ", slotNo='" + slotNo + '\'' +
                ", entryTime=" + entryTime +
                ", exitTime=" + exitTime +
                '}';
    }
}
