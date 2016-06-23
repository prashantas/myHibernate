package net.umapath;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class App {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		SessionFactory sf = HibetnateUtil.getSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		
		//For passing Date of birth as String
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date dob=null;
		try {
		dob = sdf.parse("1989-09-19");
		} catch (ParseException e) {
		e.printStackTrace();
		}

		//Worker worker = new Worker();
		
		/*worker.setFirstname("EE");
		worker.setLastname("FF");
		worker.setBirthDate(dob);
		worker.setCellphone("919566666");
		session.save(worker);
*/
		/*
       String sql = "SELECT * FROM worker";
        // String sql = "SELECT firstname, cell_phone FROM worker";
        SQLQuery query = session.createSQLQuery(sql);
        query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
        List data = query.list();

        for(Object object : data)
        {
           Map row = (Map)object;
           System.out.print("First Name: " + row.get("firstname")); 
           System.out.println(", cell_phone: " + row.get("cell_phone")); 
        }
*/        
		
		
		/*String sql = "SELECT * FROM worker";
		SQLQuery query = session.createSQLQuery(sql);
		query.addEntity(Worker.class);
		List workers = query.list();
		
		for (Iterator iterator = workers.iterator(); iterator.hasNext();) {
			Worker worker1 = (Worker) iterator.next();
			System.out.println("Worker Id:" + worker1.getWorkerId());
			System.out.println("Worker Name:" + worker1.getFirstname());
			System.out.println("Worker Birth Date:" + worker1.getBirthDate());
			System.out.println("Worker CellPhone No."+ worker1.getCellphone());
			System.out.println("-------------------------------------------");
			}

		
*/		Query query = session.getNamedQuery("findViaWorkerId").setString("workerId", "1242");
		List workers = query.list();

		
		for (Iterator iterator = workers.iterator(); iterator.hasNext();) {
		Worker worker = (Worker) iterator.next();
		System.out.println("Worker Id:" + worker.getWorkerId());
		System.out.println("Worker Name:" + worker.getFirstname());
		System.out.println("Worker Birth Date:" + worker.getBirthDate());
		System.out.println("Worker CellPhone No."+ worker.getCellphone());
		System.out.println("-------------------------------------------");
		}

		
		session.getTransaction().commit();
		session.close();
		
	}

}
