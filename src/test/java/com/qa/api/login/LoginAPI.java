package com.qa.api.login;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;


import java.io.FileReader;
import java.util.List;

import com.google.gson.JsonObject;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

import com.qa.pojo.request.LoginRequestPojo;
import com.qa.pojo.response.login.LoginResponsePojo;
import com.qa.utils.APIUtils;
import com.qa.utils.CSV_Reader;

public class LoginAPI {

	public static LoginRequestPojo getLoginRequest(int testCaseId) throws Exception {
		// TODO Auto-generated method stub
		
		String[] req_data = CSV_Reader.readCSVData(testCaseId, ".//src//test//resources//login//login_request.csv");
		LoginRequestPojo login_request = new LoginRequestPojo(req_data[1], req_data[2]);
		
		return login_request;
				
	}
	
	public static Response getLoginResponse(String headers,LoginRequestPojo login_request) throws Exception {
		// TODO Auto-generated method stub
		
		Response output = APIUtils.post(headers, "/api/login",login_request);
		
		return output;
				
	}
	
	public static LoginResponsePojo getLoginPojoResponse(Response response) throws Exception {
		// TODO Auto-generated method stub
		
		LoginResponsePojo login_response = response.as(LoginResponsePojo.class);
		
		return login_response;
				
	}

	public static void assertValidLoginResponse(int testCaseId, Response login_response) throws Exception {
		// TODO Auto-generated method stub
		String[] expectedResponseData = CSV_Reader.readCSVData(testCaseId, ".//src//test//resources//login//login_response.csv");
		LoginResponsePojo pojo_response = getLoginPojoResponse(login_response);
		
		// Assertions
		System.out.println("****************** Assert Using POJO Deserialization *********************");
		Assert.assertEquals(pojo_response.getToken(), expectedResponseData[1]);
		System.out.println("***************************************");
	}

	public static void assertValidLoginStatusCode(Response response) {
		// TODO Auto-generated method stub
		Assert.assertEquals(response.getStatusCode(), 200);

	}

	public static void assertLoginJsonSchema(Response response) {
		// TODO Auto-generated method stub
		response.then().log().all().assertThat().body(matchesJsonSchemaInClasspath("loginResponseJsonSchema.json"));
	}

	

}
