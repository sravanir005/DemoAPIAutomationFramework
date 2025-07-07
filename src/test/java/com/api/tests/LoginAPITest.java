package com.api.tests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.models.request.LoginRequest;
import com.api.models.request.SignUpRequest;
import com.api.models.response.LoginResponse;

import io.restassured.response.Response;
@Listeners(com.api.listeners.TestListener.class)
public class LoginAPITest {
	
	@Test(description="Verify Login API is working....")
	public void loginTest()
	{
		LoginRequest loginRequest=new LoginRequest("sravs1507","S19ravani99@");
		AuthService authService=new AuthService();
		Response response=authService.login(loginRequest);
		LoginResponse loginResponse=response.as(LoginResponse.class);
		System.out.println(response.asPrettyString());
		System.out.println(loginResponse.getToken());
		System.out.println(loginResponse.getEmail());
		System.out.println(loginResponse.getId());
		
		Assert.assertTrue(loginResponse.getToken()!=null);
		
		
		
		
		
		
	}

}
