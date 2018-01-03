package com.wearenoetic.devtest;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.wearenoetic.devtest.model.Department;
import com.wearenoetic.devtest.model.Employee;
import com.wearenoetic.devtest.service.EmployeeService;

@Component
public class ApplicationStartup implements ApplicationListener<ContextRefreshedEvent> {

	/**
	 * This method is called during Spring's startup.
	 * 
	 * @param event
	 *            Event raised when an ApplicationContext gets initialized or
	 *            refreshed.
	 */
	@Autowired
	private EmployeeService employeeService;

	private static final Logger logger = LoggerFactory.getLogger(ApplicationStartup.class);

	@Override
	public void onApplicationEvent(final ContextRefreshedEvent event) {

		// here your startup code ...
		createInitialEmployeeAndDepartment();		
		return;
	}
	
	
	//At the startup create dummy department and employee. 
	public void createInitialEmployeeAndDepartment(){
		
		logger.info("Employee init request received");
		try {
			Department department = new Department("IT");
			employeeService.createDepartment(department);
			department.setDepartmentID(1L);

			Employee Employee = new Employee("Prageeth", "Sudesh", department);
			employeeService.create(Employee);
		} catch (Exception e) {
			logger.error("Error occurred while trying to create employee", e);
		}		
	}

} // class
