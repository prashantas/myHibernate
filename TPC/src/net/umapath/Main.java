package net.umapath;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {

	public static void main(String[] args) {
		
		SessionFactory sf =  new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();

		
		Person person = new Person("LLL", "KKK");
		session.save(person);

		Employee employee = new Employee("JJJ", "HHH", "hr", new Date());
		session.save(employee);

		Owner owner = new Owner("FF", "DD", 698L, 34L);
		session.save(owner);

		
		session.getTransaction().commit();
		session.close();

	}
}
