package net.umapath;

import java.sql.Date;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

public class Main {

	public static void main(String[] args) {

		System.out.println("Hibernate One-To-One example (Annotation)");
		
		//SessionFactory sf = HibernateUtil.getSessionFactory();
		SessionFactory sf = new AnnotationConfiguration().configure().buildSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();

		EmployeeDetail employeeDetail = new EmployeeDetail("10th Street", "Bangalore", "Karnataka", "India");
		
		Employee employee = new Employee("ee", "rr", new Date(121212),
				"114-777-888");
		employee.setEmployeeDetail(employeeDetail);
		employeeDetail.setEmployee(employee);
		
		
		session.save(employee);

		
		/*List<Employee> list = session.createQuery("from Employee").list();
		for (Employee employee1 : list) {
			System.out.println(employee1.getFirstname() + " , "
					+ employee1.getLastname() + ", "
					+ employee1.getEmployeeDetail().getState());
		}
		*/
		
	/*	//SELECT clause with from
		Query hql = session.createQuery("select emp.cellphone from Employee emp");
		System.out.println("Displaying id from table employee");
		for(Iterator<String> it= hql.iterate(); it.hasNext();){
		//Long intr = it.next();
		System.out.println("cellphone : "+it.next());
		}
		*/
		
		
		//SELECT clause with from & where
		/*Query hql1 = session.createQuery("select emp.firstname from Employee emp where emp.employeeId = 3");
		List<String> empList1 = hql1.list();
		System.out.println("Displaying Name from table employee whose id is 3");
		for(String str : empList1)
		{
		System.out.println("Name : "+str);
		}*/
		
	/*	System.out.println("*************createCriteria***********");
	
		Criteria cr = session.createCriteria(Employee.class);*/
         // Add restriction.
        // cr.add(Restrictions.eq("firstname", "qqqq"));
      // cr.addOrder(Order.asc("firstname"));
       // cr.addOrder(Order.desc("firstname"));
		// cr.setFirstResult(1);  
		//cr.setMaxResults(2);  
		 
		//cr.setProjection(Projections.property("employeeId"));  
		 	 

        // List<Employee> emp = cr.list();
       
         /*for (Iterator iterator = 
                           employees1.iterator(); iterator.hasNext();){
            Employee employee1 = (Employee) iterator.next(); 
         */   
         /*for(Employee employee1:emp){
        	 
            System.out.print("Employee Id: " + employee1.getEmployeeId());
            System.out.print(" First Name: " + employee1.getFirstname()); 
            System.out.print("  Last Name: " + employee1.getLastname()); 
            System.out.println("  State: " + employee1.getEmployeeDetail().getState()); 
         }
*/

		session.getTransaction().commit();
		session.close();

	}
}
