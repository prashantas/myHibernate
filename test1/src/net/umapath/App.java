package net.umapath;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

public class App {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SessionFactory sf =null;
		Session session = null;
		Transaction t =null;
		try{
			
			
			Configuration cfg=new Configuration();  
		    cfg.configure("hibernate.cfg.xml");//populates the data of the configuration file  
		      
		    //creating seession factory object  
		    sf=cfg.buildSessionFactory();
		    
		  //creating session object  
		    session=sf.openSession();  
		      
		    //creating transaction object  
		    t=session.beginTransaction();  
		          
		    Emp e1=new Emp();  
		    e1.setId(99);  
		    e1.setName("xxxx");  
		      
		      
		    session.persist(e1);//persisting the object  
		      
		    t.commit();//transaction is committed
		    
			}catch(Exception e){
				  System.out.println(e.getMessage());
				  t.rollback();
			  }finally{
			  
				  session.close();  
			  } 
		    System.out.println("successfully saved");  
		      
		}  
		}  