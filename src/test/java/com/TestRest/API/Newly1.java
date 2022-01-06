package com.TestRest.API;

import static io.restassured.RestAssured.*;
import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.Cookie;
import io.restassured.response.ResponseBody;

public class Newly1 {
	
	@Test (priority = 2)
	
	void getDemo () {
		int codeStatus =  get("http://dummy.restapiexample.com/api/v1/employees").getStatusCode();
		System.out.println(" Status code : " +codeStatus);
		//Assert.assertEquals(codeStatus, 429);
		
		String lineStatus =  get("http://dummy.restapiexample.com/api/v1/employees").getStatusLine();
		System.out.println(" Status Line : " +lineStatus);
	}

	@Test (priority = 0)
	
	void getDemo_new () {
		String content = get("http://dummy.restapiexample.com/api/v1/employees").getContentType();
		System.out.println("Content : "+content);
		
		ResponseBody<?> body = get("http://dummy.restapiexample.com/api/v1/employees").getBody();
		System.out.println("Body : "+body);
		
		String cont = get("http://dummy.restapiexample.com/api/v1/employees").asPrettyString();
		System.out.println("Content : "+cont);
		
	}
	
	@Test(priority = 1)
	void getDemo1 () {
		 Cookie coookiesDetails = get("http://demo.guru99.com/V4/").getDetailedCookie(DEFAULT_BODY_ROOT_PATH);
		System.out.println(" Cookies   : " +coookiesDetails);
		

		long time = get("http://demo.guru99.com/V4/").getTime();
		System.out.println(" Time Response  : " +time);
		
		
	}

}
