package net.umapath;

import java.io.Serializable;
import java.sql.Date;

public class Employee implements Serializable {

	private Long employeeId;

	private String firstname;

	private String lastname;

	private Date birthDate;

	private String cellphone;

	private EmployeeDetail employeeDetail;

	public Employee() {

	}

	
	
	public Employee(String firstname, String lastname,
			Date birthDate, String cellphone) {
		super();
		
		this.firstname = firstname;
		this.lastname = lastname;
		this.birthDate = birthDate;
		this.cellphone = cellphone;
		
	}



	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getCellphone() {
		return cellphone;
	}

	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}

	public EmployeeDetail getEmployeeDetail() {
		return employeeDetail;
	}

	public void setEmployeeDetail(EmployeeDetail employeeDetail) {
		this.employeeDetail = employeeDetail;
	}
	
	
	

}