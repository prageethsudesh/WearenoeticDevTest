package com.wearenoetic.devtest.dao;

import java.util.List;

import com.wearenoetic.devtest.model.Department;
import com.wearenoetic.devtest.model.Employee;

public interface EmployeeDao {
    void create(Employee Employee);

    void update(Employee Employee);

    Employee getEmployeeById(long id);

    void delete(long id);

	void createDepartment(Department department);

	List<Employee> getAll();
}
