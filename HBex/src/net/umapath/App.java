package net.umapath;

import java.util.*;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Query;
import org.hibernate.Session;

public class App {

	
	public static void main(String[] args) {
		   
		Session session = HibernateUtil.getSessionFactory().openSession();

      session.beginTransaction();
      	Emp stock = new Emp();
 /*       stock.setId(9);
        
       stock.setName("uuu");
 
      session.save(stock);
 */       
    Query q = session.createQuery("update Emp s set s.Name=:n where s.Id=:i");
		
		q.setParameter("n","QQQQ");  
		q.setParameter("i",22);  
		
		int status=q.executeUpdate();  
		
		if(status == 0 || status == 1)
		{
		System.out.println(status + " row affected");
		}
		else
		System.out.println(status + " rows affected");

		System.out.println("Successfully updated");

System.out.println("**************************");


		
        session.getTransaction().commit();
        
        
        
      session.close();
		
		
		
    }

	
}
