package com.model;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "invoice")
public class Invoice {

    @Id
    @Column(name = "id")
    private String invoiceID;

    @Column(name = "inv_date")
    private Date invDate;

    @Column(name = "parking_id")
    private String parkingID;

    @Column(name = "amount_paid")
    private int amountPaid;

//    public Invoice() {
//
//    }

    public String getInvoiceID() {
        return invoiceID;
    }

    public void setInvoiceID(String invoiceID) {
        this.invoiceID = invoiceID;
    }

    public Date getInvDate() {
        return invDate;
    }

    public void setInvDate(Date invDate) {
        this.invDate = invDate;
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
                ", invDate=" + invDate +
                ", parkingID='" + parkingID + '\'' +
                ", amountPaid='" + amountPaid + '\'' +
                '}';
    }
}
