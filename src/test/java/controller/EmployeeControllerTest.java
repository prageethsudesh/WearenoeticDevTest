package controller;

import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.wearenoetic.devtest.model.Employee;
import com.wearenoetic.devtest.service.EmployeeService;

public class EmployeeControllerTest {
	
	@Autowired
	private MockMvc mockMvc;

	@Mock
	private EmployeeService employeeService;

	Employee mockEmployee = new Employee(1L,"prageeth", "sudesh",null);

	String exampleEmployeeJson = "{\"employee_id\":\"1\",\"firstname\":\"prageeth\",\"lastname\":\"sudesh\",\"department\":\"null\"}";

	@Test
	public void retrieveDetailsForEmployee() throws Exception {

//		Mockito.when(
//				employeeService.get(Mockito.anyString(),
//						Mockito.anyString())).thenReturn(mockEmployee);
//
//		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
//				"/employeeAPI/employee/1").accept(
//				MediaType.APPLICATION_JSON);
//
//		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
//
//		System.out.println(result.getResponse());
//		String expected = "{iemployee_id:1,firstname:prageeth,lastname:sudesh,department:null}";
//
//		JSONAssert.assertEquals(expected, result.getResponse()
//				.getContentAsString(), false);
	}

}
