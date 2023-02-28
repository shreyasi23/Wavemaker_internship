package com.services;

import com.model.Bus;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BusServiceImpl implements BusService{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Bus> getBuses(){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        List<Bus> BusList = session.createQuery("from Bus",Bus.class).list();
        transaction.commit();
        session.close();
        return BusList;
    }

    @Override
    public Bus createBus(Bus bus){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(bus);
        transaction.commit();
        session.close();
        return bus;
    }

    @Override
    public Bus getBusById(String id){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Bus bus = session.get(Bus.class, id);
        transaction.commit();
        session.close();
        return bus;
    }

    @Override
    public Bus updateBus(Bus bus){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(bus);
        transaction.commit();
        session.close();
        return bus;
    }

    @Override
    public Bus deleteBus(String id){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Bus bus = session.get(Bus.class, id);
        session.delete(bus);
        transaction.commit();
        session.close();
        return bus;
    }
}
