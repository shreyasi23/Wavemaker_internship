package com.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "parking_area_info")
public class ParkingAreaInfo {
    @Id
    @Column(name = "id")
    private String PAI_ID;

    @Column(name = "no_of_slots")
    private int noOfSolts;

    @Column(name = "base_price")
    private int basePrice;

    @Column(name = "per_hr_charge")
    private int perHrCharge;

//    public ParkingAreaInfo() {
//        this.PAI_ID = "PI0";
//        this.noOfSolts = 10;
//        this.basePrice = 20;
//        this.perHrCharge = 10;
//    }

    public String getPAI_ID() {
        return PAI_ID;
    }

    public void setPAI_ID(String PAI_ID) {
        this.PAI_ID = PAI_ID;
    }

    public int getNoOfSolts() {
        return noOfSolts;
    }

    public void setNoOfSolts(int noOfSolts) {
        this.noOfSolts = noOfSolts;
    }

    public int getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(int basePrice) {
        this.basePrice = basePrice;
    }

    public int getPerHrCharge() {
        return perHrCharge;
    }

    public void setPerHrCharge(int perHrCharge) {
        this.perHrCharge = perHrCharge;
    }

    @Override
    public String toString() {
        return "ParkingAreaInfo{" +
                "PAI_ID='" + PAI_ID + '\'' +
                ", noOfSolts=" + noOfSolts +
                ", basePrice=" + basePrice +
                ", perHrCharge=" + perHrCharge +
                '}';
    }
}
