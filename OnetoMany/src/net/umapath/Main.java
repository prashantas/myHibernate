package net.umapath;
 
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
 
public class Main {
 
    public static void main(String[] args) {
 
        //SessionFactory sf = HibernateUtil.getSessionFactory();
    	SessionFactory sf =new Configuration().configure().buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx =session.beginTransaction();
 
        Department department = new Department();
        department.setDepartmentName("FD");
        session.save(department);
 
        Employee emp1 = new Employee("fP", "fU", "900");
        Employee emp2 = new Employee("nik", "Blr", "999999");
 
        emp1.setDepartment(department);
      emp2.setDepartment(department);
 
        session.save(emp1);
       session.save(emp2);
 
        session.getTransaction().commit();
        session.close();
    }
}