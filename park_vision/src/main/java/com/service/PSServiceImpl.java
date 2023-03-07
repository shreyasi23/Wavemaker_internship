package com.service;

import com.model.ParkingSlots;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PSServiceImpl implements ParkingSlotsService{
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<ParkingSlots> getParkingSlots(){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        List<ParkingSlots> PSRecord = session.createQuery("from ParkingSlots",ParkingSlots.class).list();
        transaction.commit();
        session.close();
        return PSRecord;
    }

    @Override
    public ParkingSlots getSlot(String slot_no){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        ParkingSlots parkingSlots = session.get(ParkingSlots.class, slot_no);
        transaction.commit();
        session.close();
        return parkingSlots;
    }

    @Override
    public ParkingSlots updateSlotStatus(ParkingSlots parkingSlots){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(parkingSlots);
        transaction.commit();
        session.close();
        return parkingSlots;
    }
}
