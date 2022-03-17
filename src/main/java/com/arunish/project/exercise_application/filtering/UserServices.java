package com.arunish.project.exercise_application.filtering;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserServices {

private static List<User> allUsers= new ArrayList<>();
	
	static
	{
		allUsers.add(new User("Arunish","myPassword@123"));
		allUsers.add(new User("Aarif","mentorPassword@567"));
	}
	
	public List<User> getAllUsers()
	{
		return allUsers;
	}
	
	public User saveUser(User user)
	{
	    	allUsers.add(user);
	    	return user;
	}
}
