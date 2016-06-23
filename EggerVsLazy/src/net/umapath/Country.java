package net.umapath;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;


	@Entity
	public class Country implements Serializable {
		private static final long serialVersionUID = 1L;
		@Id
		@Column(name="id")
		private int id;
		
		@Column(name="name")
		private String name;
		/*
		@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
		@JoinColumn(name="countryId") 
		private Set<State> states;
*/
		
		 @OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="countryId")
	private Set<State> states;

		 
		public Country(){}
		public Country(int id, String name, Set<State> states) {
			super();
			this.id = id;
			this.name = name;
			this.states = states;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public Set<State> getStates() {
			return states;
		}

		public void setStates(Set<State> states) {
			this.states = states;
		}

		
		
		
}
