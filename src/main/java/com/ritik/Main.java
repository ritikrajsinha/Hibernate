package com.ritik;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;



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

        Laptop l2 = new Laptop();
        l2.setLid(2);
        l2.setBrand("Dell");
        l2.setModel("Xm54300");
        l2.setRam(16);

        Alien a1 = new Alien();
        a1.setAid(101);
        a1.setAname("Ritik Raj");
        a1.setTech("Java");
        a1.setLaptop(Arrays.asList(l1, l2));

        l1.setAliens(a1);
        l2.setAliens(a1);

        session.persist(l1);
        session.persist(l2);
        session.persist(a1);

        transaction.commit();
        session.close();

        // Second session - fetch and print
        // Second session - fetch and print
        Session session2 = sessionFactory.openSession();

        String brand="Asus";
        Query qs = session2.createQuery("select l.brand, l.model FROM Laptop l WHERE l.brand LIKE ?1", Object[].class);
        qs.setParameter(1, brand);
        List<Object[]> list = qs.getResultList();

        for (int i = 0; i < list.size(); i++) {
            Object[] row = list.get(i);
            System.out.println("Brand: " + row[0] + ", Model: " + row[1]);
        }


        session2.close();
        sessionFactory.close();

    }
}
