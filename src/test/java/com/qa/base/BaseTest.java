package com.qa.base;

import java.io.IOException;

import org.testng.annotations.BeforeClass;

public class BaseTest {

	public static String BaseURL;
	protected String csv;
	
	String Environment = System.getProperty("env");

	@BeforeClass(alwaysRun = true)
	public void EnvironmentUrl() throws IOException {

		System.out.println("Environment Configured in Jenkins : " + Environment);

		if (Environment == null) {
			System.out.println("Running without Jenkins env configuration");

			BaseURL = "https://reqres.in/";
			return;
		}
		if (Environment.equalsIgnoreCase("demo")) {

			System.out.println("Baseurl configuration");
			BaseURL = "https://reqres.in/";

		}
	}
	
	
	@BeforeClass
	  void setcsv(){
		  
		  csv= ".//src//test//resources//login//default_request.csv";
	  }  

}
