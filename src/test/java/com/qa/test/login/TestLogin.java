package com.qa.test.login;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.api.login.LoginAPI;
import com.qa.base.BaseTest;
import com.qa.pojo.request.LoginRequestPojo;
import com.qa.pojo.response.login.LoginResponsePojo;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TestLogin extends BaseTest {
	
	
	@BeforeClass(alwaysRun = true)
	public void Init() throws IOException {

		RestAssured.baseURI = BaseURL; //Get URL from BaseTest
		RestAssured.given().relaxedHTTPSValidation();
	}
	
	
	@Test(enabled = true, priority = 1)
	public void login_responseJsonSchema() throws Exception {

		LoginRequestPojo login_request = LoginAPI.getLoginRequest(1);
		Response login_response = LoginAPI.getLoginResponse("allHeaders",login_request);
		
		LoginAPI.assertLoginJsonSchema(login_response);

	}
	
	@Test(enabled = true, priority = 2)
	public void login_valid() throws Exception {

		
		LoginRequestPojo login_request = LoginAPI.getLoginRequest(1);
		Response login_response = LoginAPI.getLoginResponse("allHeaders",login_request);
	
		LoginAPI.assertValidLoginStatusCode(login_response);
		LoginAPI.assertValidLoginResponse(1, login_response);

	}
	
	
	

}
