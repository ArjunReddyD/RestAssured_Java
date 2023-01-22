package com.qa.test.list_users;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
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

public class TestListUsers_1 {

	@BeforeSuite()
	public void Init() throws IOException {

		System.out.println("Before suite");

	}

	
	@BeforeClass()
	public void beforeclass() throws IOException {

		System.out.println("Before class");

	}
	

	@BeforeTest()
	public void beforetest() throws IOException {

		System.out.println("Before test");

	}

	@BeforeMethod()
	public void Method() throws IOException {

		System.out.println("Before method");

	}

	@Test()
	public void test1() throws IOException {

		System.out.println("At test1");

	}
	
	@Test()
	public void test2() throws IOException {

		System.out.println("At test2");

	}


	

}
