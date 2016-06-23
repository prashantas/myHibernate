package net.umapath;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Configuration cfg=new Configuration().configure("hibernate.cfg.xml");  
		SessionFactory factory=cfg.buildSessionFactory();  
		      
		    Session session1=factory.openSession();  
		    Transaction tx1 = session1.beginTransaction();
            tx1.begin();
		    
		    Employee emp1=(Employee)session1.load(Employee.class,222);  
		    System.out.println(emp1.getId()+" "+emp1.getName()+" "+emp1.getSalary());
		    tx1.commit();
		    session1.close();  
		      
		    Session session2=factory.openSession(); 
		    Transaction tn = session2.beginTransaction();
            tn.begin();
		    Employee emp2=(Employee)session2.load(Employee.class,222);  
		    System.out.println(emp2.getId()+" "+emp2.getName()+" "+emp2.getSalary());
		    
		    
		    tn.commit();
		    session2.close(); 
		    
		    Session session3=factory.openSession(); 
		    Transaction tn1 = session3.beginTransaction();
            tn1.begin();
		    Employee emp3=(Employee)session3.load(Employee.class,222);  
		    System.out.println(emp3.getId()+" "+emp3.getName()+" "+emp3.getSalary());
		    
		    
		    tn1.commit();
		    session3.close();
	}

}
