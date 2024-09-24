package com.cache.cache_project;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "program execution started!" );
		/*
		 * Person p1 = new Person(); p1.setPid(101); p1.setPname("tom");
		 * p1.setPhno(99999); Person p2 = new Person(); p2.setPid(102);
		 * p2.setPname("john"); p2.setPhno(8888);
		 */
        Person p = null;
        Configuration con = new Configuration();
        con.configure();
        con.addAnnotatedClass(Person.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Session session1 = sf.openSession();
        Transaction trans = session.beginTransaction();
       // session.save(p1);
        //session.save(p2);
		
		  //p1=(Person)session.get(Person.class, 101);//type casting
		  //p2=(Person)session.get(Person.class,102); //creating multiple instance of same entity with same primary key in the same session then we get nonuniqueobjectException
		  //System.out.println(p1);
		 // System.out.println(p2);
       // p=(Person)session.get(Person.class,101);
       // System.out.println(p);
		//p=(Person)session.get(Person.class,101);//fires the query only one but print the output twice
		//System.out.println(p);
        //trans.commit();
        //session.close();
        p=(Person)session.get(Person.class,101);
        System.out.println(p);
        trans.commit();
        session.close();
        //we are using a differnt session here so it fires the query two times that means it going to database second time as well
        p=(Person)session1.get(Person.class,101);
        System.out.println(p);
        trans.commit();
        session.close();
        System.out.println("program execution ended!");
    }
}
