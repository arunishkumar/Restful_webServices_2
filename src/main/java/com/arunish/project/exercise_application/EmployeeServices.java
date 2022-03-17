package com.arunish.project.exercise_application;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class EmployeeServices {
          private static List<EmployeeResource> employees=new ArrayList<>();
          
          private static int emp_id=3;
          static
          {
        	  employees.add(new EmployeeResource(1,"Arunish",21));
        	  employees.add(new EmployeeResource(2,"Aarif",26));
        	  employees.add(new EmployeeResource(3,"Andrew",23));
          }
          
          //Get list of all users
          public List<EmployeeResource> getAll()
          {
        	  return employees;
          }
          
          //Get a specific user
          public EmployeeResource getEmployeeById(int id)
          {
        	  for(EmployeeResource emp:employees)
        	  {
        		  if(emp.getId()==id)
        		  {
        			  return emp;
        		  }
        	  }
        	  return null;
          }
          
          //Create a new user
          public EmployeeResource addEmployee(EmployeeResource emp)
          {
        	  if(emp.getId()==0)
        	  {
        		  emp.setId(++emp_id);
        	  }
        	  employees.add(emp);
        	  return emp;
          }
          
          //Delete a specific Employee by id
          public EmployeeResource deleteEmployeeById(int id)
          {
        	 Iterator<EmployeeResource> iterator=employees.iterator();
        	 while(iterator.hasNext())
        	 {
        		 EmployeeResource emp= iterator.next();
        		 if(emp.getId()==id)
        		 {
        			 employees.remove(emp);
        			 return emp;
        		 }
        	 } 
        	 return null;
          }
          
          //Update data of an Employee
          public EmployeeResource updateEmployee(EmployeeResource emp)
          {
        	  for(EmployeeResource empl:employees)
        	  {
        		  int emplId=empl.getId(),empId=emp.getId();
        		  if(emplId==empId)
        		  {
        			 empl.setName(emp.getName());
        			 empl.setAge(emp.getAge());
        			 return empl;
        		  }
        	  }
        	  return null;
          }
}
