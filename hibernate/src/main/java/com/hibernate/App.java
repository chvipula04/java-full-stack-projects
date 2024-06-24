package com.hibernate;
import java.util.List;
import java.util.Random;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class App 
{
    public static void main( String[] args )
    {
        Configuration config = new Configuration().configure().addAnnotatedClass(Student.class);    
        SessionFactory sf = config.buildSessionFactory();   
        Session session = sf.openSession();
        int b = 60;
        
        session.beginTransaction();
        Student st = new Student();
//        st.setMarks(90);
//        st.setName("varun");
//        st.setRollno(22335);
//        session.save(st);
        
        Query q = session.createQuery("from Student");
//        Query q = session.createQuery("select rollno,name,marks from Student");
//          Query q = session.createQuery("select sum(marks) from Student s where s.marks> :b");
//          q.setParameter("b", b);
          List<Student> s = q.list();
//          Long marks = (Long) q.uniqueResult();
        
        for(Student o : s)
        {
        	System.out.println(o.toString());
        }
//        System.out.println(marks);
        session.getTransaction().commit();
    }

}
