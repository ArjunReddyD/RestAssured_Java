package com.qa.test.list_users;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.api.list_users.ListUserAPI;
import com.qa.api.login.LoginAPI;
import com.qa.api.single.SingleUserAPI;
import com.qa.base.BaseTest;
import com.qa.pojo.request.LoginRequestPojo;
import com.qa.pojo.response.login.LoginResponsePojo;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TestListUsers extends BaseTest {
	
	
	@BeforeClass(alwaysRun = true)
	public void Init() throws IOException {

		RestAssured.baseURI = BaseURL; //Get URL from BaseTest

	}
	

	@BeforeClass
	 void setcsv(){
		  
		 csv= ".//src//test//resources//login//listuser_request.csv";
		 
	  }  
		   

	@Test(enabled = true, priority = 1)
	public void listuser_queryparam() throws Exception {

		System.out.println("csv:"+ csv);
		
		
		LoginRequestPojo login_request = LoginAPI.getLoginRequest(1);
		Response login_response = LoginAPI.getLoginResponse("allHeaders",login_request);
		
		//Example Using query param
		Response singleuser_response = ListUserAPI.getListUserQueryParamResponse(1, "allHeaders");
		
	
		SingleUserAPI.assertValidStatusCode(login_response);
		
		 
	}
	

}
