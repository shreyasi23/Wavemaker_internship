package com.model;

import javax.persistence.*;

@Entity
@Table(name = "BUS")
public class Bus {
    @Id
    @Column(name = "BUS_ID")
    private String busId;

    @Column(name = "BUS_NUMBER")
    private String busNo;

    @Column(name = "BUS_SEATS")
    private int busSeats;

    @Column(name = "START_POINT")
    private String startPoint;

    @Column(name = "END_POINT")
    private String endPoint;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "DRIVER_ID",referencedColumnName = "DRIVER_ID")
    public String getBusId() {
        return busId;
    }

    public void setBusId(String busId) {
        this.busId = busId;
    }

    public String getBusNo() {
        return busNo;
    }

    public void setBusNo(String busNo) {
        this.busNo = busNo;
    }

    public int getBusSeats() {
        return busSeats;
    }

    public void setBusSeats(int busSeats) {
        this.busSeats = busSeats;
    }

    public String getStartPoint() {
        return startPoint;
    }

    public void setStartPoint(String startPoint) {
        this.startPoint = startPoint;
    }

    public String getEndPoint() {
        return endPoint;
    }

    public void setEndPoint(String endPoint) {
        this.endPoint = endPoint;
    }
}
