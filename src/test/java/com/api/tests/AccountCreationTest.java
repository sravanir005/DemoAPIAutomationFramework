package com.api.tests;

import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.models.request.SignUpRequest;

import io.restassured.response.Response;

public class AccountCreationTest {
	
	@Test(description="Verify if SignUp api is working....")
	public void createAccountTest()
	{
		SignUpRequest signUpRequest=new SignUpRequest.Builder().username("madhu15")
				.password("madhu1599")
				.email("madhu123@gmail.com")
				.firstName("madhu")
				.lastName("reddy")
				.mobileNumber("9876543210").build();
				AuthService authService=new AuthService();
				Response response=authService.signup(signUpRequest);
				System.out.println(response.asPrettyString());
	}

}
