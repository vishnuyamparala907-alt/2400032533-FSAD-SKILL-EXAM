package com.klef.fsad.exam;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Date;

public class ClientDemo 
{
    public static void main(String[] args) 
    {
        Configuration cfg = new Configuration();
        cfg.configure();

        SessionFactory sf = cfg.buildSessionFactory();
        Session session = sf.openSession();

        Transaction tx = session.beginTransaction();

        // Insert Record
        Inventory inv = new Inventory("Laptop","Dell Laptop",new Date(),"Available");
        session.save(inv);

        tx.commit();
        System.out.println("Record Inserted Successfully");

        // Delete Record
        session = sf.openSession();
        tx = session.beginTransaction();

        Inventory i = session.get(Inventory.class,1);

        if(i!=null)
        {
            session.delete(i);
            System.out.println("Record Deleted");
        }

        tx.commit();

        session.close();
        sf.close();
    }
}