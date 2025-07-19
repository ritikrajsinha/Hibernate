package com.ritik;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Student s1=new Student();
        s1.setRollNo(3);
        s1.setName("raja ji");
        s1.setAge(29);

//        -------------------
//        Configuration cfg=new Configuration();
//        cfg.addAnnotatedClass(com.ritik.Student.class);
//        cfg.configure();

//        -----------------------------
//        SessionFactory sessionFactory=cfg.buildSessionFactory();
        SessionFactory sessionFactory=new Configuration().addAnnotatedClass(com.ritik.Student.class).configure().buildSessionFactory();
        Session session=sessionFactory.openSession();


//        -----------------------------

//     Student s2=session.get(Student.class,7);(Find query);

        Student s3=session.get(Student.class,7);






        Transaction transaction=session.beginTransaction();


//        session.persist(s1);(Create)
//        session.merge(s1);(Update)
//        session.remove(s3);(delete)



        transaction.commit();
        session.close();
        sessionFactory.close();
//        System.out.println(s2);
//        System.out.println(s2.getName()+"->"+s2.getAge());












        }
    }
