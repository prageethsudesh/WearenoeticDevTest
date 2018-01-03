package com.wearenoetic.devtest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wearenoetic.devtest.entity.ResponseModel;
import com.wearenoetic.devtest.model.Employee;
import com.wearenoetic.devtest.service.EmployeeService;

import java.util.List;
@RestController
@EnableAutoConfiguration
@RequestMapping("/employeeAPI/")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

    
    //Save Employee 
    @RequestMapping(value = "/employee", method = RequestMethod.POST)
    public ResponseEntity<ResponseModel> saveResponse(@RequestBody Employee Employee) {
    	
    	logger.info("Employee creation request received");
    	ResponseModel responseModel =new ResponseModel();

        try {
            employeeService.create(Employee);
            responseModel.setEntity(Employee);
            responseModel.setStatusCode(HttpStatus.OK.value());
        } catch (Exception e) {
            logger.error("Error occurred while trying to save employee", e);
            responseModel.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        }
    	
    	return new ResponseEntity<ResponseModel>(responseModel, HttpStatus.OK);
    }
    
    
    //Update employee
    @RequestMapping(value = "/employee", method = RequestMethod.PUT)
    public ResponseEntity<ResponseModel> updateResponse(@RequestBody Employee Employee) {
    	
    	logger.info("Employee update request received");
    	ResponseModel responseModel =new ResponseModel();

        try {
            employeeService.update(Employee);
            responseModel.setEntity(Employee);
            responseModel.setStatusCode(HttpStatus.OK.value());
        } catch (Exception e) {
            logger.error("Error occurred while trying to update employee", e);
            responseModel.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        }
    	
    	return new ResponseEntity<ResponseModel>(responseModel, HttpStatus.OK);
    }
    
    
    //Get Employee by ID
    @RequestMapping(value = "/employee/{employeeId}", method = RequestMethod.GET)
    public ResponseEntity<ResponseModel> getResponse(@PathVariable("employeeId") long employeeId) {
    	
    	logger.info("Employee get request received");
    	ResponseModel responseModel =new ResponseModel();

        try {
        	Employee Employee =employeeService.get(employeeId);
            responseModel.setEntity(Employee);
            responseModel.setStatusCode(HttpStatus.OK.value());
        } catch (Exception e) {
            logger.error("Error occurred while trying to access employee with id", e);
            responseModel.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        }
    	
    	return new ResponseEntity<ResponseModel>(responseModel, HttpStatus.OK);
    }
    
    
    //Delete Employee
    @RequestMapping(value = "/employee/{employeeId}", method = RequestMethod.DELETE)
    public ResponseEntity<ResponseModel> deleteResponse(@PathVariable("employeeId") long employeeId) {
    	
    	logger.info("Employee delete request received");
    	ResponseModel responseModel =new ResponseModel();

        try {
            employeeService.delete(employeeId);
            responseModel.setStatusCode(HttpStatus.OK.value());
        } catch (Exception e) {
            logger.error("Error occurred while trying to delete employee", e);
            responseModel.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        }
    	
    	return new ResponseEntity<ResponseModel>(responseModel, HttpStatus.OK);
    }
    
       
  //Get Employee by ID
    @RequestMapping(value = "/allEmployee", method = RequestMethod.GET)
    public ResponseEntity<ResponseModel> getResponse() {
    	
    	logger.info("Employee get request received");
    	ResponseModel responseModel =new ResponseModel();

        try {
        	List<Employee> employeeList =employeeService.getAll();
            responseModel.setEntity(employeeList);
            responseModel.setStatusCode(HttpStatus.OK.value());
        } catch (Exception e) {
            logger.error("Error occurred while trying to access employee with id", e);
            responseModel.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        }
    	
    	return new ResponseEntity<ResponseModel>(responseModel, HttpStatus.OK);
    }
    
    
}
