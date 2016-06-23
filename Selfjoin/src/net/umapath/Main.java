package net.umapath;
 
import org.hibernate.Session;
import org.hibernate.SessionFactory;
 
public class Main {
 
    public static void main(String[] args) {
 
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
        session.beginTransaction();
 
        Employee manager1 = new Employee("Sll", "Krr");
        Employee manager2 = new Employee("Sunn", "Kunn");
        Employee employee1 = new Employee("Mii", "Kann");
        Employee employee2 = new Employee("Raaa", "Redd");
        Employee employee3 = new Employee("Rrrrr", "Rgggggg");
        employee1.setManager(manager1);
        employee2.setManager(manager1);
        employee3.setManager(manager2);
       // manager1.setManager(manager1);
        manager2.setManager(manager1);
        //session.save(manager1);
        session.save(manager2);
        session.save(employee1);
        session.save(employee2);
        session.save(employee3);
        
        
        session.getTransaction().commit();
        session.close();
    }
}