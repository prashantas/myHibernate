package net.umapath;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Table;


@NamedNativeQueries({
	@NamedNativeQuery(
	name = "findViaWorkerId",
	query = "select * from worker w where w.worker_id = :workerId",
	resultClass = Worker.class
	)
	})



	@Entity
	@Table(name = "worker")
	public class Worker {

	@Id
	@GeneratedValue
	@Column(name = "worker_id")
	private Long workerId;



	@Column(name = "firstname")
	private String firstname;

	@Column(name = "lastname")
	private String lastname;

	@Column(name = "birth_date")
	private Date birthDate;

	@Column(name = "cell_phone")
	private String cellphone;

	public Worker() {

	}

	public Worker(String firstname, String lastname, Date birthdate,
			String phone) {
			this.firstname = firstname;
			this.lastname = lastname;
			this.birthDate = birthdate;
			this.cellphone = phone;

			}


	public Long getWorkerId() {
		return workerId;
	}

	public void setWorkerId(Long workerId) {
		this.workerId = workerId;
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
	
	
	
}
