package com.arunish.project.exercise_application.filtering;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class FilteringController {
          
	@Autowired
	private UserServices userService;
	
	
	
	/*@GetMapping("/user")
	//@JsonView(Views.Internal.class)
	public MappingJacksonValue displayUser()
	{	
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("userName");
		   
		   FilterProvider filters=new SimpleFilterProvider().addFilter("UserFilter", filter);
		   
		   MappingJacksonValue mapping=new MappingJacksonValue(userService.getAllUsers());
		   mapping.setFilters(filters);
		
		return mapping;
	}*/
	
	@GetMapping("/user")
	@JsonView(Views.Public.class)
	public List<User>  displayUser()
	{
		return userService.getAllUsers();
	}
	
	/*@PostMapping("/user")
	//@JsonView(Views.Public.class)
	public MappingJacksonValue addUser(@RequestBody User user)
	{
		if(user.getUserName()==null || user.getPassword()==null)
		{
			throw new CredentialsNotValid("Invalid Credentials (No fields should be NULL)");
		}
	   User savedUser=userService.saveUser(user);
	   
	   //dynamic filtering
	   
	   SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("userName");
	   
	   FilterProvider filters=new SimpleFilterProvider().addFilter("UserFilter", filter);
	   
	   MappingJacksonValue mapping=new MappingJacksonValue(savedUser);
	   mapping.setFilters(filters);
	   
	   return mapping;
	}*/
	
     @PostMapping("/user")
     @JsonView(Views.Public.class)
     public User addUser(@RequestBody User user)
 	{
 		if(user.getUserName()==null || user.getPassword()==null)
 		{
 			throw new CredentialsNotValid("Invalid Credentials (No fields should be NULL)");
 		}
 	   User savedUser=userService.saveUser(user);
 	   
 	   
 	   return savedUser;
 	}
}
