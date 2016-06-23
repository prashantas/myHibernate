package criteria.demo;

//import javax.persistence.Column;
//import javax.persistence.GeneratedValue;
//import javax.annotation.Generated;
import javax.persistence.*;
//import org.hibernate.annotations.Entity;
//import org.hibernate.annotations.Generated;
//import org.hibernate.annotations.Table;

@Entity
@Table(name = "Employee1")
public class Employee1 {
	   @Id @GeneratedValue	
	   @Column(name= "id")
	   private int id;
	   
	   @Column(name = "first_name")
	   private String firstName; 
	   
	   @Column(name = "last_name")
	   private String lastName;   
	   
	   @Column(name = "salary")
	   private int salary;  

	   public Employee1() {}
	   public Employee1(String fname, String lname, int salary) {
	      this.firstName = fname;
	      this.lastName = lname;
	      this.salary = salary;
	   }
	   public int getId() {
	      return id;
	   }
	   public void setId( int id ) {
	      this.id = id;
	   }
	   public String getFirstName() {
	      return firstName;
	   }
	   public void setFirstName( String first_name ) {
	      this.firstName = first_name;
	   }
	   public String getLastName() {
	      return lastName;
	   }
	   public void setLastName( String last_name ) {
	      this.lastName = last_name;
	   }
	   public int getSalary() {
	      return salary;
	   }
	   public void setSalary( int salary ) {
	      this.salary = salary;
	   }
	}
