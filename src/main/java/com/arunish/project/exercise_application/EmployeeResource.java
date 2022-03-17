package com.arunish.project.exercise_application;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

public class EmployeeResource {
      private int id;
      
      @Size(min=2)
      private String name;
      
      @Min(value=18)
      private int age;
      
	public EmployeeResource(int id, String name, int age) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "EmployeeResource [id=" + id + ", name=" + name + ", age=" + age + "]";
	}
      
      
}
