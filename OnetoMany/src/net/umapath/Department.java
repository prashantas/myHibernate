package net.umapath;

import java.util.List;
import java.util.Set;


	public class Department {
		 
	    private Long departmentId;
	     
	    private String departmentName;
	     
	    private Set<Employee> employees;
	 
	    public Department(){}

		public Department(Long departmentId, String departmentName,
				Set<Employee> employees) {
			super();
			this.departmentId = departmentId;
			this.departmentName = departmentName;
			this.employees = employees;
		}

		
		public Long getDepartmentId() {
			return departmentId;
		}

		public void setDepartmentId(Long departmentId) {
			this.departmentId = departmentId;
		}

		public String getDepartmentName() {
			return departmentName;
		}

		public void setDepartmentName(String departmentName) {
			this.departmentName = departmentName;
		}

		public Set<Employee> getEmployees() {
			return employees;
		}

		public void setEmployees(Set<Employee> employees) {
			this.employees = employees;
		}
	 
	    
}
