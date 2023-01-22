package com.qa.test.single;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.api.login.LoginAPI;
import com.qa.api.single.SingleUserAPI;
import com.qa.base.BaseTest;
import com.qa.pojo.request.LoginRequestPojo;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class TestSingleUser extends BaseTest {

	@BeforeClass(alwaysRun = true)
	public void Init() throws IOException {

		RestAssured.baseURI = BaseURL; //Get URL from BaseTest

	}

	
	@Test(enabled = false, priority = 1)
	public void singleuser_token() throws Exception {

		
		LoginRequestPojo login_request = LoginAPI.getLoginRequest(1);
		Response login_response = LoginAPI.getLoginResponse("allHeaders",login_request);
		
		String token = LoginAPI.getLoginPojoResponse(login_response).getToken();
		
		//Example passing token from login to next response
		Response singleuser_response = SingleUserAPI.getSingleUserResponse("allHeaders", token);
		
	
		SingleUserAPI.assertValidStatusCode(login_response);
		

	}
	
	@Test(enabled = true, priority = 2)
	public void singleuser_pathparam() throws Exception {

		
		LoginRequestPojo login_request = LoginAPI.getLoginRequest(1);
		Response login_response = LoginAPI.getLoginResponse("allHeaders",login_request);
		
		//Example Using path param
		Response singleuser_response = SingleUserAPI.getSingleUserPathParamResponse(1, "allHeaders");
		
	
		SingleUserAPI.assertValidStatusCode(login_response);
		

	}

	
}
