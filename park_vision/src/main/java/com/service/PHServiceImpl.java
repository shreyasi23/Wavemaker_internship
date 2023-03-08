package com.service;

import com.model.ParkingHistory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PHServiceImpl implements ParkingHistoryService{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<ParkingHistory> getParkingHistory(){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        List<ParkingHistory> PHRecord = session.createQuery("from ParkingHistory",ParkingHistory.class).list();
        transaction.commit();
        session.close();
        return PHRecord;
    }
    @Override
    public ParkingHistory recordParkingInfo(ParkingHistory parkingHistory){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(parkingHistory);
        transaction.commit();
        session.close();
        return parkingHistory;
    }

    @Override
    public List<ParkingHistory> getHistory(String license_plate_no){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        NativeQuery<ParkingHistory> nativeQuery = session.createNativeQuery("select * from parking_history where license_plate_no=:licenseId", ParkingHistory.class);
        nativeQuery.setParameter("licenseId",license_plate_no);
        List list = nativeQuery.list();
        transaction.commit();
        session.close();
        return list;
    }

    @Override
    public ParkingHistory updateParkingRecord(ParkingHistory parkingHistory){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(parkingHistory);
        transaction.commit();
        session.close();
        return parkingHistory;
    }
}
