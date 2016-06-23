package net.umapath;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class Main {

	public static void main(String[] args) {

		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();

		
		Person person = new Person("QQQ", "WW");
		session.save(person);

		Employee employee = new Employee("EE", "RR", "Marketing", new Date());
		session.save(employee);

		Owner owner = new Owner("TTT", "YY", 400L, 40L);
		session.save(owner);

		
		session.getTransaction().commit();
		session.close();

	}
}
