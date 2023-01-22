package com.qa.utils;

import com.qa.pojo.request.LoginRequestPojo;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class APIUtils {

	public static RequestSpecification getRequestSpecification() {
		// TODO Auto-generated method stub
		RequestSpecification httpRequest = RestAssured.given();
		httpRequest.log().all();
		
		return httpRequest;
	}
	
	public static RequestSpecification getHeaderRequestSpecification(String headers) {
		// TODO Auto-generated method stub
		RequestSpecification httpRequest = RestAssured.given();
		httpRequest.log().all();
		httpRequest = getHeaderDetails(httpRequest, headers);
		
		return httpRequest;
	}
	
	public static RequestSpecification getHeaderRequestSpecification(String headers,String token) {
		// TODO Auto-generated method stub
		RequestSpecification httpRequest = RestAssured.given();
		httpRequest.log().all();
		httpRequest = getHeaderDetails(httpRequest, headers);
		httpRequest.header("token", token);
		
		
		return httpRequest;
	}
	
	public static RequestSpecification getHeaderRequestSpecification(String headers,String[] query_param) {
		// TODO Auto-generated method stub
		RequestSpecification httpRequest = RestAssured.given();
		httpRequest.log().all();
		httpRequest = getHeaderDetails(httpRequest, headers);
		
		setQueryParam(httpRequest,query_param);
		
		return httpRequest;
	}

	private static RequestSpecification setQueryParam(RequestSpecification httpRequest, String[] query_param) {
		// TODO Auto-generated method stub
		for(int i=4; i< query_param.length; i=i+2) {
			httpRequest.queryParam(query_param[i], query_param[i+1]);
		}
		
		return httpRequest;
	}

	public static RequestSpecification getHeaderDetails(RequestSpecification httpRequest, String headers) {
		// TODO Auto-generated method stub
		
		if (headers.equals("allHeaders")) {
			httpRequest.header("X-Requested-With", "XMLHttpRequest");
			httpRequest.header("Content-Type", "application/json");
			httpRequest.header("X-cs-session-id", "true");

		}

		if (headers.equals("missingContentType")) {
			httpRequest.header("X-Requested-With", "XMLHttpRequest");
			httpRequest.header("X-cs-session-id", "true");

		}

		if (headers.equals("cookieHeaders")) {
			httpRequest.header("X-Requested-With", "XMLHttpRequest");
			httpRequest.header("Content-Type", "application/json");

		}

		return httpRequest;
	
	}

	public static Response get(String headers,String path) {
		// TODO Auto-generated method stub
		RequestSpecification httpRequest = getHeaderRequestSpecification(headers);
		
		return httpRequest.get(path);
	}

	public static Response post(String headers, String path, Object request_body) {
		// TODO Auto-generated method stub
		RequestSpecification httpRequest = getHeaderRequestSpecification(headers);
		
		return httpRequest.body(request_body).post(path);
	}
	
	public static Response put(RequestSpecification httpRequest, String path, Object request_body) {
		// TODO Auto-generated method stub
		return httpRequest.body(request_body).put(path);
	}
		
	public static Response get(String headers,String token, String path) {
		// TODO Auto-generated method stub
		RequestSpecification httpRequest = getHeaderRequestSpecification(headers, token);
		
		return httpRequest.get(path);
	}
	
	public static Response post(String headers,String token, String path, Object request_body) {
		// TODO Auto-generated method stub
		RequestSpecification httpRequest = getHeaderRequestSpecification(headers, token);
		
		return httpRequest.body(request_body).post(path);
	}

	public static Response get(String headers, String path, String[] query_param) {
		// TODO Auto-generated method stub
		RequestSpecification httpRequest = getHeaderRequestSpecification(headers, query_param);
		
		return httpRequest.get(path);
	}


}
