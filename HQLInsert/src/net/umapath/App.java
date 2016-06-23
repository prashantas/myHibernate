package net.umapath;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class App {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
    
		 SessionFactory sf = HibernateUtil.getSessionFactory();
	        Session session = sf.openSession();
	        session.beginTransaction();
	        Query query = session.createQuery("insert into SalesOrder(stockId, price)" + " select stockId, price from Stock where stockId = 66");
	        Query query1 = session.createQuery("update SalesOrder set purchaser=:n where stockId=:i");
	        query1.setParameter("n","Ria4"); 
	        query1.setParameter("i",66); 
	        int update = query.executeUpdate();
	        int update1 = query1.executeUpdate();
	        if(update == 0 || update == 1)
	        {
	        System.out.println(update + " row affected");
	        }
	        else
	        System.out.println(update + " rows affected");

	        System.out.println("Inserted Records Successfully");
	        
	        
	        session.getTransaction().commit();
	        
	        session.close();
	}

}
