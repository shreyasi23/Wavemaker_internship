package com.model;

import javax.persistence.*;



@Entity
@Table(name = "invoice")
public class Invoice {
    @Id
    @Column(name = "id")
    private int invoiceID;

    @Column(name = "parking_id")
    private String parkingID;

    @Column(name = "amount_paid")
    private int amountPaid;


    public int getInvoiceID() {
        return invoiceID;
    }

    public void setInvoiceID(int invoiceID) {
        this.invoiceID = invoiceID;
    }

    public String getParkingID() {
        return parkingID;
    }

    public void setParkingID(String parkingID) {
        this.parkingID = parkingID;
    }

    public int getAmountPaid() {
        return amountPaid;
    }

    public void setAmountPaid(int amountPaid) {
        this.amountPaid = amountPaid;
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "invoiceID='" + invoiceID + '\'' +
                ", parkingID='" + parkingID + '\'' +
                ", amountPaid=" + amountPaid +
                '}';
    }
}
