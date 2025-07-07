package com.api.tests;

import org.testng.annotations.Test;

import com.api.base.AuthService;

import io.restassured.response.Response;

public class ForgotPasswordTest {
	
	@Test(description="Verify if Forgot Password api is working....")
	public void forgotPassword()
	{
		AuthService authService=new AuthService();
		Response response=authService.forgotPassword("rangaiahgari.sravani15@gmail.com");
		System.out.println(response.asPrettyString());
	}

}
