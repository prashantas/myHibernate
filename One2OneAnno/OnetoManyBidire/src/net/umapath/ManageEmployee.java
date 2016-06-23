package net.umapath;

import java.util.HashSet;
import java.util.Iterator;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;


public class ManageEmployee {
	private static SessionFactory sf;
	
	public static void main(String[] args) {
		try {
			
			sf = new AnnotationConfiguration().configure().buildSessionFactory();
		} catch (Throwable ex) {
			System.err.println("Failed to create sessionFactory object." + ex);
			throw new ExceptionInInitializerError(ex);
		}
		System.out.println("Hibernate One to Many Bi-Directional Mapping Example ");
		Session session = sf.openSession();
		session.beginTransaction();
		
		//Address to Employee mapping
		System.out.print(".....Address to Employee mapping......");
		Address address = new Address();
		address.setStreet("W Bank");
		address.setCity("N Delhi");
		address.setState("Delhi");
		address.setCountry("India");
 
        Employee e1 = new Employee("Ro", "Th", "999");
        Employee e2 = new Employee("Sm", "Kha", "333");
 
        address.setEmployees(new HashSet<Employee>());
        address.getEmployees().add(e1);
        address.getEmployees().add(e2);
 
        session.save(address);
        
       //Employee to Address mapping
        System.out.print(".....Employee to Address mapping....");
        Address address1 = new Address();
		address1.setStreet("L Gard");
		address1.setCity("Kolk");
		address1.setState("W Beng");
		address1.setCountry("Ind");
        session.save(address1);
 
        Employee e3 = new Employee("R1", "S", "111");
        Employee e4 = new Employee("K1", "Km", "222");
 
        e3.setAddress(address1);
        e4.setAddress(address1);
 
        session.save(e3);
        session.save(e4);
        
        
       /* System.out.println("*************************Hibernate Inner Join Example*************************");
String hql = "select e.firstname,e.lastname,e.cellphone,a.city,a.state,a.country from Employee e inner join e.address as a";
*/

        
        System.out.println("*************************Hibernate Left Outer Join Example*************************");
        String hql = "select e.firstname,e.lastname,e.cellphone,a.city,a.state,a.country from Employee e left join e.address as a";
        
        
      //  System.out.println("*************************Hibernate Right Outer Join Example*************************");
      //  String hql = "select e.firstname,e.lastname,e.cellphone,a.city,a.state,a.country from Employee e right join e.address as a";
        
     
Query query = session.createQuery(hql);

System.out.println("First Name\t" + "Last Name\t" + "Cell Phone\t" + "City\t\t" + "State\t" + "Country\t");
System.out.println("--------------------------------------------------------------------------------");

        
        
        

for (Iterator it = query.iterate(); it.hasNext();) {
Object[] row = (Object[]) it.next();
System.out.print(row[0]);
System.out.print("\t\t" + row[1]);
System.out.print("\t\t" + row[2]);
System.out.print("\t" + row[3]);
System.out.print("\t" + row[4]);
System.out.print("\t" + row[5]);
System.out.println();
}

       
        
        
        
        session.getTransaction().commit();
        session.close();
	}
}
