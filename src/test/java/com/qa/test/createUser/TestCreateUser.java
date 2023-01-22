package com.qa.test.createUser;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.api.login.LoginAPI;
import com.qa.base.BaseTest;
import com.qa.pojo.request.LoginRequestPojo;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class TestCreateUser extends BaseTest{

	@BeforeClass
	public void init() {
		
		RestAssured.baseURI = BaseURL;
		
	}

	@Test(priority=1, enabled=true)
	public void createValidNewUser() throws Exception {
		
		LoginRequestPojo loginReq = LoginAPI.getLoginRequest(1);
		Response login_response = LoginAPI.getLoginResponse("allHeaders", loginReq);           
		
		String token = LoginAPI.getLoginPojoResponse(login_response).getToken();
		
	}
}
