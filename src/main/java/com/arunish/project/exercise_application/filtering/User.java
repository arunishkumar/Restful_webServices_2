package com.arunish.project.exercise_application.filtering;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;

@JsonFilter("UserFilter")
public class User{
	
	     //@JsonView(Views.Public.class)
         private String userName;
         
         //@JsonIgnore
	     //@JsonView(Views.Internal.class)
         private String password;
         
         
		public User(String userName, String password) {
			super();
			this.userName = userName;
			this.password = password;
		}


		public String getUserName() {
			return userName;
		}


		public void setUserName(String userName) {
			this.userName = userName;
		}


		public String getPassword() {
			return password;
		}


		public void setPassword(String password) {
			this.password = password;
		}
         
         
}
