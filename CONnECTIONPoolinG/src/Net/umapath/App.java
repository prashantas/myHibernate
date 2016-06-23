package Net.umapath;

import java.util.Date;
import org.hibernate.Session;


public class App {
	public static void main(String[] args) {
		System.out.println("Maven + Hibernate Annotation + Oracle");
		Session session = HibernateUtil.getSessionFactory().openSession();
		Session session1 = HibernateUtil.getSessionFactory().openSession();


		session.beginTransaction();
		DBUser user = new DBUser();

		user.setUserId(101);
		user.setUsername("Hibernate102");
		user.setCreatedBy("system1");
		user.setCreatedDate(new Date());
		session.save(user);
		session.getTransaction().commit();
		
		session1.beginTransaction();
		DBUser user1 = new DBUser();

		user1.setUserId(102);
		user1.setUsername("Hibernate102");
		user1.setCreatedBy("system2");
		user1.setCreatedDate(new Date());
		session1.save(user1);
		session1.getTransaction().commit();
		
		System.out.println("Done");
	}
}
