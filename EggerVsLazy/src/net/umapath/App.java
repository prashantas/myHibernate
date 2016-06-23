package net.umapath;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;

public class App {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Session session=HibernateUtil.getSessionFactory().openSession();
    	session.beginTransaction();
    	State s1= new State(1,1,"UP");
    State s2= new State(2,1,"MP");
    	Set<State> states= new HashSet<State>();
    	states.add(s1);
    	states.add(s2);
    	Country country= new Country(1,"India",states);
    	session.persist(country);
    	session.getTransaction().commit();
    	session.close();
    	//start new session to check fetch type
        session=HibernateUtil.getSessionFactory().openSession();
    	session.beginTransaction();
    	Country con= (Country)session.get(Country.class,new Integer(1));
		//access collection
    	System.out.println(con.getStates().size());
        session.clear();
    }
	

}
