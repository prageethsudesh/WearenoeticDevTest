package com.wearenoetic.devtest.service;

import java.util.List;

import com.wearenoetic.devtest.model.Department;
import com.wearenoetic.devtest.model.Employee;

public interface EmployeeService {
	
	Employee create(Employee Employee);
    Employee get(long EmployeeId);
    Employee update(Employee Employee);
    boolean delete(long EmployeeId);
    
	void createDepartment(Department department);
	List <Employee> getAll();
}
