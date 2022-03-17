package com.arunish.project.exercise_application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeMessage {
	
	@Autowired
	private MessageSource messageSource;
     
	@GetMapping("/PrintMessage")
	public String printMessage()
	{
		return "Welcome to Spring Boot";
	}
	
	@GetMapping("/hello/{name}")
	public String printHelloUsername(@PathVariable String name)
	{
		return String.format("Hello %s", name);
	}
	
	@GetMapping(path = "/hello-world-internationalized")
	public String helloWorldInternationalized() {
		return messageSource.getMessage("good.morning.message", null, 
									LocaleContextHolder.getLocale());
	}
} 
