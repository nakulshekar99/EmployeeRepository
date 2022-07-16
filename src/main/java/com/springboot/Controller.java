package com.springboot;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class Controller {
	@Autowired
	private Service service;
	@RequestMapping(method=RequestMethod.POST,value="/create")
	public MessageResponse create(@RequestBody Employee employeeRequest)
	{
		return service.create(employeeRequest);
	}
	@RequestMapping(method=RequestMethod.GET,value="/all")
	public ResponseEntity<List<Employee>> getAllEmployee()
	{
		List<Employee>employees=service.getAll();
		return new ResponseEntity<>(employees,HttpStatus.OK);
	}
	@RequestMapping(method=RequestMethod.GET,value="/find/{id}")
	public ResponseEntity<Employee>getEmployeebyId(@PathVariable("id")Integer emp_id)
	{
		Employee employee= service.single(emp_id);
		return new ResponseEntity<>(employee,HttpStatus.OK);
	}
	@RequestMapping(method=RequestMethod.PUT,value="/update/{id}/{location}")
	public Employee update(@RequestBody Employee employeerequest, @PathVariable("id")Integer emp_id,@PathVariable("location")String location) throws  ResourceNotFoundException
	{
		 
		 return service.update(emp_id, employeerequest);
	}

}
