package com.qa.api.single;

import com.qa.pojo.request.LoginRequestPojo;
import com.qa.utils.APIUtils;
import com.qa.utils.CSV_Reader;

import io.restassured.response.Response;
import junit.framework.Assert;

public class SingleUserAPI {

	public static Response getSingleUserResponse(String headers, String token) {
		// TODO Auto-generated method stub
		
		return APIUtils.get(headers, token, "/api/users/2");
	}
	
	public static Response getSingleUserPathParamResponse(int testCaseId, String headers) throws Exception {
		// TODO Auto-generated method stub
		String[] req_data = CSV_Reader.readCSVData(testCaseId, ".//src//test//resources//singleuser//singleuser_request.csv");
		
		
		return APIUtils.get(headers, "/api/users/"+req_data[3]);
	}

	public static void assertValidStatusCode(Response response) {
		// TODO Auto-generated method stub
		
			Assert.assertEquals(response.getStatusCode(), 200);

		
	}

}
