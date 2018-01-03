package com.wearenoetic.devtest.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "department")
@XmlRootElement
public class Department implements  Serializable{

   
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="department_id")
    private Long departmentID;
    
	public Department(){
		
	}
	
    public Department(String name) {
		super();
		this.name = name;
	}

	@Column(name="name")
    private String name;
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "department")
    private Set<Employee> EmployeeSet; 
    
    
    public Long getDepartmentID() {
		return departmentID;
	}

	public void setDepartmentID(Long departmentID) {
		this.departmentID = departmentID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Employee> getEmployeeSet() {
		return EmployeeSet;
	}

	public void setEmployeeSet(Set<Employee> employeeSet) {
		EmployeeSet = employeeSet;
	}
}
