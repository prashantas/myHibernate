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
		
		SessionFactory sessionFactory1 = new  Configuration().configure("oracle.cfg.xml").buildSessionFactory();
	    SessionFactory sessionFactory2 = new Configuration().configure("mysql.cfg.xml").buildSessionFactory();
	    Session session = null;
	    Transaction transaction = null;
	    Employee e =new Employee();
	    e.setEmpid(889);
        e.setEmpname("sunil");

	    try {
	    	Session session1 = sessionFactory1.openSession();
            transaction = session1.beginTransaction();
            transaction.begin();
            
            session1.save(e);
            transaction.commit();
           session1.close();
            
           Session session2 = sessionFactory2.openSession();
            transaction = session2.beginTransaction();
            transaction.begin();
           
            session2.save(e);
            transaction.commit();
            session2.close();
        } catch (Exception he) {
            he.printStackTrace();
            
        }
        


	}

}
