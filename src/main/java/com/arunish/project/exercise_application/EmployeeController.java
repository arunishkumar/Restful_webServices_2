package com.arunish.project.exercise_application;


import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
 
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeServices empObj;
	
	@GetMapping("/Employee-Bean")
	public EmployeeResource EmployeeBean()
	{
		return new EmployeeResource(1,"Arunish",21);
	}
	
	@GetMapping("/Employee")
	public List<EmployeeResource> getEmployeeList()
	{
		return empObj.getAll();
	}
	
	@GetMapping("/Employee/{id}")
	public EntityModel<EmployeeResource> getOneEmployee(@PathVariable int id)
	{
		EmployeeResource emp=empObj.getEmployeeById(id);
		if(emp==null)
		{
			throw new UserNotFoundException("Id- "+id);
		}
		
		//Bad Technique to hardcode link path
		
		
		//in Hateoas we find link from function
		EntityModel<EmployeeResource> resource=EntityModel.of(emp);
		
		WebMvcLinkBuilder linkTo = linkTo(methodOn(this.getClass()).getEmployeeList());
		
		
		resource.add(linkTo.withRel("all_employees_list"));
		return resource;
	}
	
	@PostMapping("/Employee")
	public ResponseEntity<EmployeeResource> createEmployee(@Valid @RequestBody EmployeeResource emp)
	{
		EmployeeResource savedEmp=empObj.addEmployee(emp);
		
		//return created response back along with URI(Uniform Resource Identifier)
		//Employee/{id}
		URI location=ServletUriComponentsBuilder.fromCurrentRequest().path("{id}").buildAndExpand(savedEmp.getId()).toUri();
		
		return ResponseEntity.created(location).build();
	}
	
	@DeleteMapping("/Employee/{id}")
	public String removeEmployee(@PathVariable int id)
	{
		EmployeeResource emp=empObj.deleteEmployeeById(id);
		if(emp==null)
		{
			throw new UserNotFoundException("id- "+id);
		}
	    return "User Deleted with Employee Id : "+id;
	}
	
	@PutMapping("/Employee")
	public EmployeeResource update(@RequestBody EmployeeResource emp)
	{
		EmployeeResource updatedEmployee=empObj.updateEmployee(emp);
		if(updatedEmployee==null)
		{
			throw new UserNotFoundException("id- "+emp.getId());
		}
		return updatedEmployee;
	}
}
