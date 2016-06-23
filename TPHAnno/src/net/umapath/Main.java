package net.umapath;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class Main {

	public static void main(String[] args) {

		SessionFactory sf = new AnnotationConfiguration().configure().buildSessionFactory();
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
