package net.umapath;

import java.util.Iterator;
import java.util.List;

import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.hibernate.*;

public class FetchData {
	public static void main(String[] args) {

		Configuration configuration=new Configuration();
		configuration.configure("hibernate.cfg.xml");
		SessionFactory sFactory=configuration.buildSessionFactory();
		Session session=sFactory.openSession();
				
		
		//Hibernate Named Query
		Query query = session.getNamedQuery("findEmployeeByName");
		query.setString("name", "Nikhil");
		
		List<Employee> employees=query.list();
		
		/*Iterator<Employee> itr=employees.iterator();
		while(itr.hasNext()){
		Employee e=itr.next();
		System.out.println(e);
		*/
	for(Object o:employees)	{
		System.out.println(o);
	}
		
		session.close();
	
	}

}
