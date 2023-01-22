package com.qa.api.CreateUser;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.api.login.LoginAPI;
import com.qa.base.BaseTest;
import com.qa.pojo.request.LoginRequestPojo;
import com.qa.utils.APIUtils;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import junit.framework.Assert;

public class CreateUserAPI {
	
	public static Response getCreateUsersAPIResponse(String headers, String token, CreateUserAPI reqBody) {
		
		return APIUtils.post(headers, token, "/api/users", reqBody);
		
	}
	
	public static void assertValidStatusCode(Response response) {
		//String[] req_data = 
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	
}
