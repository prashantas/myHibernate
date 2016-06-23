package net.demo;



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
		Session session1 = null;
		Transaction tx1 = null;
        System.out.println("start main");
        
		try{
		   // This step will read hibernate.cfg.xml and prepare hibernate for use
			SessionFactory sf = new Configuration().configure().buildSessionFactory();
		  //SessionFactory sf1 = new Configuration().configure(hebernate.cfg.xml).buildSessionFactory();
			session1 =sf.openSession();
		  //Create new instance of Contact and setvalues in it by reading them from form object
			System.out.println("Inserting Record");
			tx1 = session1.beginTransaction();
		 
			Employee emp = new Employee();
			emp.setId(2);
			emp.setName("Gavakshya");
			session1.save(emp);
			System.out.println("Done");
		  
			tx1.commit();
		  }catch(Exception e){
			  System.out.println(e.getMessage());
			  tx1.rollback();
		  }
		  finally{
		  // Actual contact insertion will happen at this step
		//  session1.flush();
		  session1.close();

		  }
		  
	  }

	}

//}
