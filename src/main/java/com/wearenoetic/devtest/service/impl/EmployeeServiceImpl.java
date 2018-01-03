package com.wearenoetic.devtest.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wearenoetic.devtest.dao.EmployeeDao;
import com.wearenoetic.devtest.model.Department;
import com.wearenoetic.devtest.model.Employee;
import com.wearenoetic.devtest.service.EmployeeService;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;

    @Override
	public Employee create(Employee employee) {
        employeeDao.create(employee);
        return employee;
    }

	@Override
	public Employee get(long employeeId) {
		return employeeDao.getEmployeeById(employeeId);
	}

	@Override
	public Employee update(Employee employee) {
		employeeDao.update(employee);
		return employee;
	}

	@Override
	public boolean delete(long employeeId) {
		employeeDao.delete(employeeId);
		return false;
	}

	@Override
	public void createDepartment(Department department) {
		employeeDao.createDepartment(department);		
	}

	@Override
	public List<Employee> getAll() {
		return employeeDao.getAll();
	}
}
