package com.ritik;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import java.util.*;



import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .addAnnotatedClass(Alien.class)
                .addAnnotatedClass(Laptop.class)
                .configure()
                .buildSessionFactory();

        // First session - save data
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Laptop l1 = new Laptop();
        l1.setLid(1);
        l1.setBrand("Asus");
        l1.setModel("Xs123");
        l1.setRam(8);



        Alien a1 = new Alien();
        a1.setAid(101);
        a1.setAname("Ritik Raj");
        a1.setTech("Java");
        a1.setLaptop(Arrays.asList(l1));

        l1.setAliens(a1);


        session.persist(l1);
        session.persist(a1);

        transaction.commit();
        session.close();

        // Second session - fetch and print
        // Second session - fetch and print
       Session session2 = sessionFactory.openSession();

        Query<Object[]> query = session2.createQuery(
                "SELECT a, l FROM Laptop l JOIN l.aliens a", Object[].class);
        List<Object[]> result = query.getResultList();

        for (int i = 0; i < result.size(); i++) {
            Object[] row = result.get(i);

            Alien alien = (Alien) row[0];
            Laptop laptop = (Laptop) row[1];

            System.out.println("Row " + (i + 1) + ":");
            System.out.println("Alien -> ID: " + alien.getAid() + ", Name: " + alien.getAname() + ", Tech: " + alien.getTech());
            System.out.println("Laptop -> ID: " + laptop.getLid() + ", Brand: " + laptop.getBrand() + ", Model: " + laptop.getModel() + ", RAM: " + laptop.getRam());
            System.out.println("---------------------------------------------------");
        }
        session2.close();
        sessionFactory.close();

    }
}
