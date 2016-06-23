package criteria.demo;

import java.util.Iterator;
import java.util.List;

import criteria.demo.Employee1;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.criterion.Restrictions;

public class ManageEmployee {

	/**
	 * @param args
	 */
	private static SessionFactory factory;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			
			factory = ((AnnotationConfiguration) new AnnotationConfiguration().
	                   configure()).
	                   addPackage("criteria.demo"). //add package if used.
	                   addAnnotatedClass(Employee1.class).
	                   buildSessionFactory();
		}catch(Throwable x){
			System.out.println("failed to create session factory object:"+ x);
			//throw new ExceptionInInitializerError(x); 
		}
		
		ManageEmployee ME = new ManageEmployee();
		/* Add few employee records in database */
	      Integer empID1 = ME.addEmployee("Pr", "Al", 1000);
	      Integer empID2 = ME.addEmployee("Ra", "Da", 5000);
	      Integer empID3 = ME.addEmployee("Ga", "Pa", 10000);
	      
	      /* List down all the employees */
	      //ME.listEmployees();
		
		
	}
	
	public Integer addEmployee(String fname, String lname, int salary){
		Session session = factory.openSession();
		Transaction tx = null;
		Integer employeeId = null;
		try{
			tx = session.beginTransaction();
			Employee1 employee = new Employee1(fname,lname,salary);
			employeeId = (Integer) session.save(employee);
			tx.commit();
		}catch(HibernateException e){
			if(tx!=null) tx.rollback();
			e.printStackTrace();
		}finally{
			session.close();
		}
		
		return employeeId;
	}// end of addEmployee function
	
	/*Method to read all the employees having salary more than 2000 */
	public void listEmployees(){
		Session session = factory.openSession();
		Transaction tx = null;
		try{
			
			tx = session.beginTransaction();
			Criteria cr = session.createCriteria(Employee1.class);
			cr.add(Restrictions.gt("salary", 2000));
			List employees = cr.list();
			
			for(Iterator iterator = employees.iterator(); iterator.hasNext();){
				Employee1 employee  = (Employee1) iterator.next();
				System.out.print("First Name: " + employee.getFirstName()); 
	            System.out.print("  Last Name: " + employee.getLastName()); 
	            System.out.println("  Salary: " + employee.getSalary()); 
			}
			
		}catch(HibernateException e){
			if(tx!=null) tx.rollback();
			e.printStackTrace();
			
		}finally{
			session.close();
		}
	}

}// end of class ManageEmployee
