package com.ritik;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
//        Student s1=new Student();
//        s1.setRollNo(3);
//        s1.setName("raja ji");
//        s1.setAge(29);

//        -----------------------------

        Laptop l1=new Laptop();
        l1.setLid(1);
        l1.setBrand("asus");
        l1.setModel("Xs123");
        l1.setRam(8);


        Laptop l2=new Laptop();
        l2.setLid(2);
        l2.setBrand("Dell");
        l2.setModel("Xm54300");
        l2.setRam(16);

        Laptop l3=new Laptop();
        l3.setLid(3);
        l3.setBrand("Macbook pro");
        l3.setModel("AirO2");
        l3.setRam(32);

        Alien a1=new Alien();
        a1.setAid(101);
        a1.setAname("Ritik Raj");
        a1.setTech("Java");
        a1.setLaptop(Arrays.asList(l1,l3));

        Alien a2=new Alien();
        a2.setAid(102);
        a2.setAname("Raj");
        a2.setTech("React");
        a2.setLaptop(Arrays.asList(l1,l2));

        Alien a3=new Alien();
        a3.setAid(103);
        a3.setAname("Rahul");
        a3.setTech("js");
        a3.setLaptop(Arrays.asList(l2,l3));

        l1.setAliens(Arrays.asList(a1,a2));
        l2.setAliens(Arrays.asList(a2,a3));
        l3.setAliens(Arrays.asList(a1,a3));







//        -------------------
//        Configuration cfg=new Configuration();
//        cfg.addAnnotatedClass(com.ritik.Student.class);
//        cfg.configure();

//        -----------------------------
//        SessionFactory sessionFactory=cfg.buildSessionFactory();
        SessionFactory sessionFactory=new Configuration().addAnnotatedClass(com.ritik.Alien.class).addAnnotatedClass(com.ritik.Laptop.class).configure().buildSessionFactory();
        Session session=sessionFactory.openSession();


//        -----------------------------

//     Student s2=session.get(Student.class,7);(Find query);

//       Alien a3=session.get(Alien.class,1);






        Transaction transaction=session.beginTransaction();


//        session.persist(s1);(Create)
//        session.merge(s1);(Update)
//        session.remove(a3);

        session.persist(l1);
        session.persist(l2);
        session.persist(l3);

        session.persist(a1);
        session.persist(a2);
        session.persist(a3);




        transaction.commit();
        session.close();
        sessionFactory.close();
//        System.out.println(a3);
//      System.out.println(s2.getName()+"->"+s2.getAge());












        }
    }
