package net.umapath;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class Main {

	public static void main(String[] args) {

		//SessionFactory sf = HibernateUtil.getSessionFactory();
		SessionFactory sf = new AnnotationConfiguration().configure().buildSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();

		
		Person person = new Person("UUUU", "bb");
		person.setPersonId(1L);
		session.save(person);

		Employee employee = new Employee("OOOO", "ddd", "Marketing", new Date());
		employee.setPersonId(2L);
		session.save(employee);

		Owner owner = new Owner("vvv", "tttt", 300L, 20L);
		owner.setPersonId(3L);
		session.save(owner);

		
		session.getTransaction().commit();
		session.close();

	}
}
