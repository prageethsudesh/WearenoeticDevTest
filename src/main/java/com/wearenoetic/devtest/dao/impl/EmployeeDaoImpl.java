package com.wearenoetic.devtest.dao.impl;

import org.springframework.stereotype.Repository;

import com.wearenoetic.devtest.dao.EmployeeDao;
import com.wearenoetic.devtest.model.Department;
import com.wearenoetic.devtest.model.Employee;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void create(Employee employee) {
        entityManager.persist(employee);
    }

    @Override
    public void update(Employee employee) {
        entityManager.merge(employee);
    }

    @Override
    public Employee getEmployeeById(long id) {
        return entityManager.find(Employee.class, id);
    }

    @Override
    public void delete(long id) {
        Employee employee = getEmployeeById(id);
        if (employee != null) {
            entityManager.remove(employee);
        }
    }

	@Override
	public void createDepartment(Department department) {
		entityManager.persist(department);
		
	}

	@Override
	public List<Employee> getAll() {
		
		return entityManager.createQuery("SELECT e FROM Employee e", Employee.class).getResultList();
		 		
	}


}
