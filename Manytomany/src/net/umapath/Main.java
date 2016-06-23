package net.umapath;
 
import org.hibernate.Session;
import org.hibernate.SessionFactory;
 
public class Main {
 
    public static void main(String[] args) {
 
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
        session.beginTransaction();
 
        
        Meeting meeting1 = new Meeting("Daily meeting");
        Meeting meeting2 = new Meeting("monthly meeting");
        
        Employee employee1 = new Employee("AAA", "BBB");
        Employee employee2 = new Employee("CCC", "GGG");
        Employee employee3 = new Employee("PPP", "UUU");

        employee1.getMeetings().add(meeting1);
        employee1.getMeetings().add(meeting2);
        employee2.getMeetings().add(meeting1);
        
        session.save(employee1);
        session.save(employee2);
        session.save(employee3);
        
        session.getTransaction().commit();
        session.close();
    }
}