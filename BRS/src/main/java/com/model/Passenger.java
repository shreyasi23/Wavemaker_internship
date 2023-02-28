package com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PASSENGER")
public class Passenger {
    @Id
    @Column(name = "PASSENGER_ID")
    private String passedngerID;

    @Column(name = "PASSENGER_NAME")
    private String passengerName;

    @Column(name = "GENDER")
    private String gender;

    @Column(name = "AGE")
    private int age;

    @Column(name = "PASSENGER_PH")
    private String passenger_ph;

    public String getPassedngerID() {
        return passedngerID;
    }

    public void setPassedngerID(String passedngerID) {
        this.passedngerID = passedngerID;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPassenger_ph() {
        return passenger_ph;
    }

    public void setPassenger_ph(String passenger_ph) {
        this.passenger_ph = passenger_ph;
    }
}
