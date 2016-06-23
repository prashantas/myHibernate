package com.net;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
			    Session session=new Configuration().configure()  
			                            .buildSessionFactory().openSession();  
			    Transaction t=session.beginTransaction();  
			      
		    Answer ans1=new Answer();  
		
		    ans1.setAnswername("java is a programming language"); 

		    //ans1.setPostedby("Ravi Malik");  
		      
		    Answer ans2=new Answer();  
		    ans2.setAnswername("java is a platform");  
		    ans2.setPostedby("Sudhir Kumar");  
		      
		    Answer ans3=new Answer();  
		    ans3.setAnswername("Servlet is an Interface");  
		    ans3.setPostedby("Jai Kumar");  
		      
		    Answer ans4=new Answer();  
		    ans4.setAnswername("Servlet is an API");  
		    ans4.setPostedby("Arun");  
		      
		    Answer ans5=new Answer();  
		    ans5.setAnswername("Servlet is an Interface");  
		    ans5.setPostedby("Jai Kumar");  
		      
		    Answer ans6=new Answer();  
		    ans6.setAnswername("Servlet is an API");  
		    ans6.setPostedby("Arun");  
		    
		    
		    
		    List<Answer> list1=new ArrayList<Answer>();  
		    list1.add(ans1);  
		    list1.add(ans2);  
		      
		    List<Answer> list2=new ArrayList<Answer>();  
		    list2.add(ans3);  
		    list2.add(ans4); 
		    list2.add(ans5);  
		    list2.add(ans6); 
		    
		    //ArrayList<Answer> list3=new ArrayList<Answer>(); 
		    //list3.add(ans5);  
		   // list3.add(ans6);  
		    Question question1=new Question();  
		    question1.setQname("What is Java?");  
		    question1.setAnswers(list1);  
		      
		    Question question2=new Question();  
		    question2.setQname("What is Servlet?"); 
		    
		    question2.setAnswers(list2);
		  // question2.setAnswers(list3);
		      
		    session.persist(question1);  
		    session.persist(question2);  
		      
		    t.commit();  
		    session.close();  
		    System.out.println("success");  
		}  
		}  
