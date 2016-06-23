package net.umapath;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity

@DiscriminatorValue("EMP")
public class Employee extends Person {

	@Column(name="joining_date")
	private Date joiningDate;
	
	@Column(name="department_name")
	private String departmentName;

	public Employee() {
	}
	
	
	public Employee(String firstname, String lastname, String departmentName, Date joiningDate) {
		
		super(firstname, lastname);
		
		this.departmentName = departmentName;
		this.joiningDate = joiningDate;
	}
	
	/*public Date getJoiningDate() {
		return joiningDate;
	}
	public void setJoiningDate(Date joiningDate) {
		this.joiningDate = joiningDate;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}*/
}
