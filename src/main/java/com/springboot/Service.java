package com.springboot;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class Service {
	@Autowired
	private EmployeeRepository repo;
	public MessageResponse create(Employee employeeRequest)
	{
		
		employeeRequest.setEmpid(employeeRequest.getEmpid());
		employeeRequest.setFirstname(employeeRequest.getFirstname());
		employeeRequest.setSurname(employeeRequest.getSurname());
		employeeRequest.setLocation(employeeRequest.getLocation());
		repo.save(employeeRequest);
		return new MessageResponse("Employee created");
	}
	public Employee update(Integer emp_id,Employee employeerequest)throws ResourceNotFoundException
	{
	      Optional<Employee>employee=repo.findById(emp_id);
	      if(employee.isEmpty())
	      {
	    	  throw new ResourceNotFoundException("No such Employee");
	      }
	      else
	      {
	    	Employee obj = employee.get();
	    	obj.setFirstname(employeerequest.getFirstname());
	    	 obj.setSurname(employeerequest.getSurname());
	    	 obj.setLocation(employeerequest.getLocation());
	    	 
	    	
	    	  repo.save(obj);
	      
		
		
		return obj;
	      }
	}
	public Employee single(Integer emp_id)
	{
		return repo.findById(emp_id).get();
	}
	public List<Employee> getAll()
	{
		List<Employee>list=repo.findAll();
		 list.sort(Comparator.comparing(Employee::getFirstname));
		 return list;
		
	}



}
