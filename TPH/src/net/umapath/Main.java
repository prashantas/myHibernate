package net.umapath;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class Main {

	public static void main(String[] args) {

		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();

		
		Person person = new Person("FFF", "GGGG");
		session.save(person);
		Owner owner = new Owner("FF", "DD", 698L, 34L);
		session.save(owner);
		Employee employee = new Employee("RRRR", "TTTT", "HR", new Date());
		session.save(employee);
		
		session.getTransaction().commit();
		session.close();

	}
}
