package net.umapath;

import java.sql.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {

	public static void main(String[] args) {

		//SessionFactory sf = HibernateUtil.getSessionFactory();
		SessionFactory sf =new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();

		EmployeeDetail employeeDetail = new EmployeeDetail("24-street", "bangalore", "KarnATAKA", "iNdia");
		
		Employee employee = new Employee("AAA", "CCCC", new Date(23444),
				"114-857-965");
		employee.setEmployeeDetail(employeeDetail);
		employeeDetail.setEmployee(employee);
		
		
		session.save(employee);

		/*
		List<Employee> employees = session.createQuery("from Employee").list();
		for (Employee employee1 : employees) {
			System.out.println("Get the data from table");
			System.out.println(employee1.getFirstname() + " , "
					+ employee1.getLastname() + ", "
					+ employee1.getEmployeeDetail().getState());
		}*/

		session.getTransaction().commit();
		session.close();

	}
}
