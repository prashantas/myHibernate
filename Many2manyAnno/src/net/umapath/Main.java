package net.umapath;
 
import org.hibernate.Session;
import org.hibernate.SessionFactory;
 
public class Main {
 
    public static void main(String[] args) {
 
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
        session.beginTransaction();
 
        
        Meeting meeting1 = new Meeting("Weekly Sales meeting");
        Meeting meeting2 = new Meeting("Daily Status meeting");
        
        Employee employee1 = new Employee("aVBVV", "FDDDSSS");
        Employee employee2 = new Employee("EDDDS", "QWERR");
        Employee employee3 = new Employee("EEEEE", "FFFFFF");

        employee1.getMeetings().add(meeting1);
        employee1.getMeetings().add(meeting2);
        employee2.getMeetings().add(meeting1);
        employee3.getMeetings().add(meeting2);
        
        session.save(employee1);
        session.save(employee2);
        session.save(employee3);
        
        session.getTransaction().commit();
        session.close();
    }
}