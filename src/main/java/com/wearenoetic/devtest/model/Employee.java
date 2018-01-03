package com.wearenoetic.devtest.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "employee")
@XmlRootElement
public class Employee implements  Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;



	public Employee(){
		
	}
	
	
    public Employee(String firstname, String lastname, Department department) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.department = department;
	}
    
    public Employee(Long employeeID,String firstname, String lastname, Department department) {
		super();
		this.employeeID=employeeID;
		this.firstname = firstname;
		this.lastname = lastname;
		this.department = department;
	}

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="employee_id")
    private Long employeeID;
    
    @Column(name="firstname")
    private String firstname;
    
    @Column(name="lastname")
    private String lastname;
      
    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "department_id", nullable = false)
    private Department department;
    

	public Long getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(Long employeeID) {
		this.employeeID = employeeID;
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

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}
    
}
