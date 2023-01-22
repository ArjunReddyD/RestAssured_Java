package com.qa.api.list_users;

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

public class ListUserAPI {
	
	
	public static Response getListUserQueryParamResponse(int testCaseId, String headers) throws Exception {
		// TODO Auto-generated method stub
		String[] req_data = CSV_Reader.readCSVData(testCaseId, ".//src//test//resources//listuser//listuser_request.csv");
		
		
		
		return APIUtils.get(headers, "/api/users", req_data);
	}
 
	

}
