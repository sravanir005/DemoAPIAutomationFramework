package com.api.tests;

import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.base.UserService;
import com.api.models.request.LoginRequest;
import com.api.models.response.LoginResponse;
import com.api.models.response.UserProfileResponse;

import io.restassured.response.Response;

public class GetProfileTest {
	
	@Test(description="Verify if the get profile api is working...")
	public void getProfileInfoTest()
	{
		AuthService authService=new AuthService();
		Response response=authService.login(new LoginRequest("sravs1507","S19ravani99@"));
		LoginResponse loginResponse=response.as(LoginResponse.class);
		
		UserService userService=new UserService();
		response=userService.getProfile(loginResponse.getToken());
		System.out.println(response.asPrettyString());
		
		UserProfileResponse userResponse=response.as(UserProfileResponse.class);
		System.out.println(userResponse.getFirstName());
		System.out.println(userResponse.getEmail());
		
	}

}
