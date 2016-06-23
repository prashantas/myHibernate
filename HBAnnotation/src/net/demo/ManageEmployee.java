package net.demo;

import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;



public class ManageEmployee {

	private static SessionFactory factory; 
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try{
			//factory = new Configuration().configure().buildSessionFactory();
			factory = ((AnnotationConfiguration) new AnnotationConfiguration().
	                   configure()).
	                   addPackage("net.demo"). //add package if used.
	                   addAnnotatedClass(Employee1.class).
	                   buildSessionFactory();
		}catch(Throwable x){
			System.out.println("failed to create session factory object:"+ x);
			//throw new ExceptionInInitializerError(x); 
		}
		
		ManageEmployee ME = new ManageEmployee();
		 /* Add few employee records in database */
	      Integer empID1 = ME.addEmployee("A", "Ali", 1000);
	      Integer empID2 = ME.addEmployee("B", "Das", 5000);
	      Integer empID3 = ME.addEmployee("C", "Paul", 10000);
	      
	      /* List down all the employees */
	      ME.listEmployees();
	      
	      /* Update employee's records */
	      ME.updateEmployee(empID1, 5000);

	      /* Delete an employee from the database */
	      ME.deleteEmployee(empID2);

	      /* List down new list of the employees */
	      ME.listEmployees();
	}

	public Integer addEmployee(String fname, String lname, int salary){
		Session session = factory.openSession();
		Transaction tx = null;
		Integer employeeID = null;
		try{
			tx = session.beginTransaction();
			Employee1 employee = new Employee1(fname,lname,salary);
			employeeID = (Integer)session.save(employee);
			tx.commit();
		}catch(HibernateException e){
			
			if(tx!=null) tx.rollback();
			e.printStackTrace();
		}finally{
			session.close();
		}
		return employeeID ;
	}
	/* Method to  READ all the employees */
	   public void listEmployees( ){
		   Session session = factory.openSession();
		   Transaction tx = null;
		   try{
			   tx = session.beginTransaction();
			   List employees = session.createQuery("FROM Employee1").list();
			   for(Iterator iterator= employees.iterator(); iterator.hasNext();){
				   Employee1 employee = (Employee1) iterator.next();
				   System.out.print("First Name: " + employee.getFirstName()); 
		            System.out.print("  Last Name: " + employee.getLastName()); 
		            System.out.println("  Salary: " + employee.getSalary()); 
				   
			   }
			   tx.commit();
		   }catch(HibernateException e){
			   if(tx!=null) tx.rollback();
			   e.printStackTrace();
		   }finally{
			   session.close();
		   }
	   }
	   
	   /* Method to UPDATE salary for an employee */
	   public void updateEmployee(Integer EmployeeID, int salary ){
		   Session session = factory.openSession();
		   Transaction tx = null;
		   try{
			   tx = session.beginTransaction();
			   Employee1 employee = (Employee1)session.get(Employee1.class,EmployeeID);
			   employee.setSalary(salary);
			   session.update(employee);
			   tx.commit();
		   }catch(HibernateException e){
			   if(tx!=null) tx.rollback();
			   e.printStackTrace();
		   }finally{
			   session.close();
		   }
	   }
	   /* Method to DELETE an employee from the records */
	   public void deleteEmployee(Integer EmployeeID){
		   Session session = factory.openSession();
		   Transaction tx = null;
		   try{
			   tx = session.beginTransaction();
			   Employee1 employee = (Employee1)session.get(Employee1.class,EmployeeID);
			   session.delete(employee);
			   tx.commit();
		   }catch(HibernateException e){
			   if(tx!=null) tx.rollback();
			   e.printStackTrace();
		   }finally{
			   session.close();
		   }
	   }
}
