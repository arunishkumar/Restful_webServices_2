package com.arunish.project.exercise_application.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersionController {

	
	
	//MimeType versioning
	@GetMapping(value = "/userDetails/produces", produces = "application/vnd.company.app-v1+json")
	public UserDetailsV1 getUserDetailsMimeTypeV1()
	{
		return new UserDetailsV1("Arunish");
	}

	@GetMapping(value = "/userDetails/produces", produces = "application/vnd.company.app-v2+json")
	public UserDetailsV2 getUserDetailsMimeTypeV2()
	{
		return new UserDetailsV2("Arunish",21,"Delhi");
	}
	
	
	
	//Request Parameter Versioning
	@GetMapping(value="/userDetails/param",params="Version=1")
	public UserDetailsV1 getUserDetailsParamsV1()
	{
		return new UserDetailsV1("Arunish");
	}
	
	@GetMapping(value="/userDetails/param",params="Version=2")
	public UserDetailsV2 getUserDetailsParamsV2()
	{
		return new UserDetailsV2("Arunish",21,"Delhi");
	}
	
	//URI versioning
	@GetMapping("/v1/userDetails")
	public UserDetailsV1 getUserDetailsV1()
	{
		return new UserDetailsV1("Arunish");
	}
	
	@GetMapping("/v2/userDetails")
	public UserDetailsV2 getUserDetailsV2()
	{
		return new UserDetailsV2("Arunish",21,"Delhi");
	}
	
	//custom header versioning
	@GetMapping(value = "/userDetails/header", headers = "X-API-VERSION=1")
	public UserDetailsV1 getUserDetailsHeaderV1() {
		return new UserDetailsV1("Arunish");
	}

	@GetMapping(value = "/userDetails/header", headers = "X-API-VERSION=2")
	public UserDetailsV2 getUserDetailsHeaderV2() {
		return new UserDetailsV2("Arunish",21,"Delhi");
	}
	
	
}
