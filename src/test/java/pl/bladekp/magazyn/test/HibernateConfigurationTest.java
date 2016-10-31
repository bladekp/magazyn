package pl.bladekp.magazyn.test;

import org.hibernate.Session;
import pl.bladekp.magazyn.model.Parameter;
import pl.bladekp.magazyn.util.HibernateUtil;

public class HibernateConfigurationTest {
    public static void main(String args[]){
        Parameter p = new Parameter();
        p.setName("Current");
        p.setUnit("I");
        p.setMeasure("A");
        p.setDescription("Current");
        
        //creating
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(p);
        session.getTransaction().commit();
        System.out.println("Parameter " + p.getName() + " ID: " + p.getId());
        
        //deleting
        session.beginTransaction();
        session.delete(p);
        session.getTransaction().commit();
        
        //closing session
        session.close();
    }
}