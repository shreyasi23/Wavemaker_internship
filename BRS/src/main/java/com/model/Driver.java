package com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigInteger;

@Entity
@Table(name = "DRIVER")
public class Driver {
    @Id
    @Column(name = "DRIVER_ID")
    private String driverId;

    @Column(name = "DRIVER_NAME")
    private String driverName;

    @Column(name = "DRIVER_PH")
    private BigInteger driver_ph_no;

    public String getDriverId() {
        return driverId;
    }

    public void setDriverId(String driverId) {
        this.driverId = driverId;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public BigInteger getDriver_ph_no() {
        return driver_ph_no;
    }

    public void setDriver_ph_no(BigInteger driver_ph_no) {
        this.driver_ph_no = driver_ph_no;
    }

    @Override
    public String toString() {
        return "Driver{" +
                "driverId='" + driverId + '\'' +
                ", driverName='" + driverName + '\'' +
                ", driver_ph_no=" + driver_ph_no +
                '}';
    }
}
