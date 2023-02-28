package com.services;

import com.model.Bus;
import com.model.Driver;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DriverServiceImpl implements DriverService{
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Driver> getDrivers(){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        List<Driver> DriverList = session.createQuery("from Driver",Driver.class).list();
        transaction.commit();
        session.close();
        return DriverList;
    }

    @Override
    public Driver createDriver(Driver driver){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(driver);
        transaction.commit();
        session.close();
        return driver;
    }

    @Override
    public Driver getDriverById(String id){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Driver driver = session.get(Driver.class, id);
        transaction.commit();
        session.close();
        return driver;
    }

    @Override
    public Driver updateDriver(Driver driver){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(driver);
        transaction.commit();
        session.close();
        return driver;
    }

    @Override
    public Driver deleteDriver(String id){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Driver driver = session.get(Driver.class, id);
        session.delete(driver);
        transaction.commit();
        session.close();
        return driver;
    }
}
